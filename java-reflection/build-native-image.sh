#!/bin/bash


export JAVA_HOME=$GRAALVM_HOME/jre
export PATH=$JAVA_HOME/bin:/$GRAALVM_HOME/bin:$PATH


#native-image --expert-options-all


native-image \
    -jar target/java-reflection-1.0-SNAPSHOT-jar-with-dependencies.jar \
    -H:ReflectionConfigurationFiles=reflection.json \
    -H:Name=BeerService


# -H:ReflectionConfigurationFiles=reflection.json

# Not working ?
# -H:Features=io.millesabords.graalvm.examples.reflection.ReflectionRegistrationFeature \

