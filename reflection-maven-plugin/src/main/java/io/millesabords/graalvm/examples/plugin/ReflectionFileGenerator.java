package io.millesabords.graalvm.examples.plugin;

import io.millesabords.graalvm.examples.helper.reflection.ReflectionConfiguration;
import io.millesabords.graalvm.examples.helper.reflection.ReflectionFileHelper;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class ReflectionFileGenerator extends AbstractMojo {

    /** List of classes to take into account for the generation. */
    @Parameter(property = "generate.classes", required = true)
    private String classes;

    @Parameter(property = "generate.file", required = true)
    private String file;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        getLog().info("Loading the follonwing classes: " + classes);

        List<ReflectionConfiguration> configs = Arrays.stream(classes.split(","))
                .map(String::trim)
                .map(c -> new ReflectionConfiguration(c, true, true, true, true))
                .collect(Collectors.toList());

        try {
            ReflectionFileHelper.generateFile(configs, file);
        }
        catch (IOException e) {
            getLog().error("File generation", e);
        }
    }
}
