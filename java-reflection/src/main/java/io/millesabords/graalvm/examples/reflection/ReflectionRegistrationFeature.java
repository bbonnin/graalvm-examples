package io.millesabords.graalvm.examples.reflection;

//import com.oracle.svm.core.annotate.AutomaticFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.graalvm.nativeimage.Feature;
import org.graalvm.nativeimage.RuntimeReflection;

/**
 * TODO: build the project with this annotation
 */
//@AutomaticFeature
public class ReflectionRegistrationFeature implements Feature {

    public void beforeAnalysis(BeforeAnalysisAccess access) {
        RuntimeReflection.register(Beer.class);
    }
}
