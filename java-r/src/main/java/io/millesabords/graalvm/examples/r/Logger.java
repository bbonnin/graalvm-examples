package io.millesabords.graalvm.examples.r;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

/**
 * Logger used by Java and R.
 */
public class Logger {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger("java-r");

    public static void log(Object... args) {
        LOG.info(String.format("%s", String.join(" ",
                Arrays.stream(args).map(Object::toString).collect(toList()))));
    }
}
