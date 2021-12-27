FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/space-flight-news-0.0.1-SNAPSHOT.jar /app/space-app.jar

ENTRYPOINT ["java", "-jar", "space-app.jar"]