# java-reflection

This project is an example on how to develop a simple web service 
with SparkJava, Jackson and Lombok (using reflection) and to build a native image, 
and all this with `GraalVM`

> Do not forget to set JAVA_HOME to the GraalVM bin directory


## Basic

### Build

```
mvn package
```

## Run

```
mvn exec:java
```


## Native image

### Build

* First, package the project
``` 
mvn package -Pnative-image
```

* Then, create the native image
```
./build-native-image.sh
```

> It is necessary to help GraalVM with the reflection
> See the content of `relection.json` and the content of `build-native-image.sh`



### Run

```
./BeerService
```