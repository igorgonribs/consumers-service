FROM openjdk:11-jdk
ARG JAR_FILE=jarfile/*.jar
COPY ${JAR_FILE} consumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/consumer-0.0.1-SNAPSHOT.jar"]