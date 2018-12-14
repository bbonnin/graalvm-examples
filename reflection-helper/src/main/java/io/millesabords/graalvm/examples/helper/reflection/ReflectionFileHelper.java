package io.millesabords.graalvm.examples.helper.reflection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReflectionFileHelper {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void generateFile(List<ReflectionConfiguration> configs, String reflectJsonFilename)
            throws IOException {

        final String reflectJson = gson.toJson(configs);

        FileUtils.write(new File(reflectJsonFilename), reflectJson, "UTF-8");

        System.out.println("File generated: " + reflectJsonFilename);
        System.out.println("# of classes: " + configs.size());
    }
}
