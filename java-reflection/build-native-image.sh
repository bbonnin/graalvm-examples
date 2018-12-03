#!/bin/bash


export JAVA_HOME=$GRAALVM_HOME/jre
export PATH=$JAVA_HOME/bin:/$GRAALVM_HOME/bin:$PATH


native-image -cp target/*:target/lib/* \
    io.millesabords.graalvm.examples.reflection.BeerService \
    -H:ReflectionConfigurationFiles=reflection.json \
    -H:Name=BeerService
