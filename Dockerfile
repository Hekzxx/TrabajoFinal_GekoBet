# Etapa de construcción
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/gekobetv1-0.0.1-SNAPSHOT.jar gekobetv1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/gekobetv1.jar"]