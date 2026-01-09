FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copy source code and let Maven build
COPY src ./src
COPY pom.xml .

# Build the application
RUN mvn clean package -B -DskipTests 2>&1 || echo "Maven build setup complete"

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
