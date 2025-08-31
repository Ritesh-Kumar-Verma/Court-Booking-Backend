# ---------- Build Stage ----------
FROM maven:3.9.11-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml first (for dependency caching)
COPY pom.xml .

# Copy source code
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package -DskipTests -U

# ---------- Run Stage ----------
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Create folder for H2 database persistence
RUN mkdir -p /app/data

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
