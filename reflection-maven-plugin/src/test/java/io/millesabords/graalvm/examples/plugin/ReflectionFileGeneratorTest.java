package io.millesabords.graalvm.examples.plugin;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

public class ReflectionFileGeneratorTest extends AbstractMojoTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void test() throws Exception {
        File pom = getTestFile("src/test/resources/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        ReflectionFileGenerator generator = (ReflectionFileGenerator) lookupMojo("generate", pom);
        assertNotNull(generator);

        generator.execute();
    }
}
