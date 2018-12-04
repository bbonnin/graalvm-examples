FROM oracle/graalvm-ce:1.0.0-rc9

EXPOSE 4567

COPY target/*-jar-with-dependencies.jar beerservice.jar
COPY reflection.json /

RUN native-image --no-server \
        -jar beerservice.jar \
        -H:ReflectionConfigurationFiles=reflection.json \
        -H:Name=BeerService

CMD ./BeerService
