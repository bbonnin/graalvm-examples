# graalvm-examples

Some GraalVM examples

## Pre-requisite

* Install `GraalVM`
* Set your `JAVA_HOME` to the JDK of your installation of GraalVM, for example:
```
export GRAALVM_HOME=/path/to/graalvm
export JAVA_HOME=$GRAALVM_HOME
export PATH=$GRAALVM_HOME/bin:$PATH
```

## Examples

* __java-reflection__: 
  * how to play with reflection when using a native image
  * how to create a docker image hosting your binary
* __java-r__: how to develop a polyglot application (R for the data exploration and Java for the web service)
* __reflection-helper__: project helping the developpers to create the reflection configuration file
  * it provides an annotation `ReflectionHelper` that must be used on classes that you want to be present in the configuration file