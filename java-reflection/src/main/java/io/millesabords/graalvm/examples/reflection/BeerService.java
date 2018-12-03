package io.millesabords.graalvm.examples.reflection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static spark.Spark.*;


public class BeerService {

    private static final Map<String, Beer> beers = new HashMap<>();

    private static final AtomicInteger counter = new AtomicInteger(0);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        before((req, res) -> res.type("application/json"));

        get("/user", (req, res) -> beers.values(), mapper::writeValueAsString);

        get("/user/:id", (req, res) -> {
            final String id = req.params("id");

            if (beers.containsKey(id)) {
                return beers.get(id);
            }
            else {
                res.status(404);
                return "beer not found... did you drink it?";
            }
        }, mapper::writeValueAsString);

        post("/user", (req, res) -> {
            final String name = req.queryParams("name");
            final String country = req.queryParams("country");
            final Beer beer = new Beer(counter.incrementAndGet(), name, country);

            beers.put(Integer.toString(beer.getId()), beer);

            return beer;
        }, mapper::writeValueAsString);
    }
}
