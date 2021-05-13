FROM webdevops/liquibase

ARG SCHEMA_JAR_DIR
ARG SCHEMA_JAR

RUN apt-get update && apt-get install -y wget && apt-get install -y dos2unix && rm -rf /var/lib/apt/lists/*

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

COPY ./docker/db_liquibase/waitOnDbAndRunLiquibase.sh /
RUN dos2unix /waitOnDbAndRunLiquibase.sh
RUN chmod +x /waitOnDbAndRunLiquibase.sh

COPY $SCHEMA_JAR_DIR/$SCHEMA_JAR /liquibase
RUN unzip  /liquibase/$SCHEMA_JAR
RUN rm /liquibase/liquibase.properties

COPY ./docker/db_liquibase/mysql-connector-java-8.0.18.jar /

WORKDIR /liquibase
CMD /waitOnDbAndRunLiquibase.sh