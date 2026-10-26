# Stage 1: build the jar with the Maven wrapper
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -q dependency:go-offline
COPY src src
RUN ./mvnw -q -DskipTests package

# Stage 2: run the jar on a small Java runtime image
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Hosting platforms like Render pass the port in $PORT; the app reads it (defaults to 8080)
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
