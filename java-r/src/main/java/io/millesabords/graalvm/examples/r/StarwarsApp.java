package io.millesabords.graalvm.examples.r;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class StarwarsApp {

    private static final Gson GSON = new Gson();


    public static void main(String[] args) throws Exception {

        final Context graalvmCtx = Context.newBuilder().allowAllAccess(true).build();

        final Source starwarsSrc = Source.newBuilder("R",
                StarwarsApp.class.getResource("/starwars.R")).build();

        final Value rCode = graalvmCtx.eval(starwarsSrc);

        // The R script file contains several functions: plotRevenue, revenueStats
        //
        final Function<ParamsHolder, String> plotRFct = rCode.getMember("plotRevenue").as(Function.class);
        final Supplier<Map> statsRFct = rCode.getMember("revenueStats").as(Supplier.class);

        // Set the csvFilename used by revenueStats function
        //
        graalvmCtx.getBindings("R").putMember("csvFilename", "starwars.csv");

        staticFiles.location("/public");
        //staticFiles.externalLocation("src/main/resources/public");

        get("/starwars/svg/:trilogies", (req, res) -> {
            final String trilogies = req.params(":trilogies");
            Logger.log("CODE JAVA - trilogies=" + trilogies);

            final String svg = plotRFct.apply(
                    new ParamsHolder("starwars.csv", trilogies));

            res.type("image/svg+xml");

            return svg;
        });

        get("/starwars/stats", (req, res) -> {
            Logger.log("CODE JAVA - stats");

            res.type("application/json");

            return GSON.toJson(statsRFct.get());
        });
    }
}
