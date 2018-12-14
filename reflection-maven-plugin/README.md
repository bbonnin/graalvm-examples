# reflection-maven-plugin

> Maven plugin to generate a reflection file for GraalVM

## Install

```
mvn install
```

## Usage

In the `pom.xml` of your project:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>io.millesabords.graalvm.examples</groupId>
            <artifactId>reflection-maven-plugin</artifactId>
            <version>1.0-SNAPSHOT</version>            
            <configuration>
                <classes>my.project.GreatData,my.project.NiceData</classes>
                <file>reflect.json</file>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Then, run:
```
mvn reflection:generate
```

## TODO

* Use an annotation to declare classes to include in the file