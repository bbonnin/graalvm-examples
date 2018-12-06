# reflection-helper

This project provides a generator of reflection configuration files needed to help GraalVM 
on reflection.

## Build

```
mvn clean install
```

## How to

In your project:

* Add the dependency on this project in your project
```xml
<dependency>
  <groupId>io.millesabords.graalvm.examples</groupId>
  <artifactId>reflection-helper</artifactId>
  <version>...</version>
</dependency>
```
* Annotate your classes with `ReflectionHelper`
```java
@ReflectionHelper
public class Beer {
    String name;
    ...
}
```

* Use the generator to create the config file
```
mvn exec:java -Dexec.args="my-graalvm-app.jar reflection.json"

# or

java -jar target/reflection-helper-1.0-SNAPSHOT-jar-with-dependencies.jar my-graalvm-app.jar reflection.json
```

You should get a file with something like that:
```json
[
  {
    "name": "my.package.Beer",
    "allDeclaredFields": true,
    "allPublicFields": true,
    "allDeclaredMethods": true,
    "allPublicMethods": true
  }
]
```

## Next steps

* Add more options on the annotation (or create new annotations for fields and methods)
* Create a maven plugin
