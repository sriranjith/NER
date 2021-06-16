FROM maven:3.6.0-jdk-11-slim AS build
COPY src /app/src
COPY ner /app/ner
COPY pom.xml /app
RUN mvn -f /app/pom.xml install

FROM openjdk:11-jre-slim
COPY --from=build /app/target/NER-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar", "server"]