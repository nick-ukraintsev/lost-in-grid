# syntax=docker/dockerfile:1
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN ./gradlew build --no-daemon

EXPOSE 8080

CMD ["java", "-jar", "build/libs/lost-in-grid-backend-0.0.1-SNAPSHOT.jar"]
