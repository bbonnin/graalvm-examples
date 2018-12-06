package io.millesabords.graalvm.examples.helper.reflection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ReflectionFileGenerator {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Problem with the arguments...");
            System.err.println("Arguments should be: <jar with the classes annotated with ReflectionHelper> <reflection file name>");
            System.exit(1);
        }

        final String jarFilename = args[0];
        final String reflectJsonFilename = args[1];

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final File jarFile = new File(jarFilename);
        final URL jarUrl = jarFile.toURI().toURL();
        final URLClassLoader sysLoader = URLClassLoader.newInstance(new URL[] { jarUrl });

        final Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(jarUrl)
                .addClassLoader(sysLoader)
                .setScanners(new SubTypesScanner(false), new TypeAnnotationsScanner()));

        final Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(ReflectionHelper.class);
        final List<ReflectionConfiguration> configs = classSet.stream()
                .map(c -> new ReflectionConfiguration(c.getName(), true, true, true, true))
                .collect(Collectors.toList());

        final String reflectJson = gson.toJson(configs);

        FileUtils.write(new File(reflectJsonFilename), reflectJson, "UTF-8");

        System.out.println("File generated: " + reflectJsonFilename);
        System.out.println("# of classes: " + classSet.size());
    }
}
