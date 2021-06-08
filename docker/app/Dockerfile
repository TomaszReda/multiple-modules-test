FROM openjdk:16

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=test-backend/target/test-backend-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

RUN mkdir -p /var/test/logs/
RUN chmod +wrx /var/test/logs
ENTRYPOINT ["java","-jar","/app.jar"]