package io.millesabords.graalvm.examples.helper.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReflectionConfiguration {

    private String name;
    private boolean allDeclaredFields = true;
    private boolean allPublicFields = true;
    private boolean allDeclaredMethods = true;
    private boolean allPublicMethods = true;
}
