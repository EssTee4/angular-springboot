FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# copy Maven wrapper and pom first for better caching
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src ./src

RUN mvn -B -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
