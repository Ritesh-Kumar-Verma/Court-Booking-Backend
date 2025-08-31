# ---------- Run Stage ----------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the prebuilt JAR
COPY target/Court_Booking-0.0.1-SNAPSHOT.jar app.jar

# Create data folder for H2 database
RUN mkdir -p /app/data

EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
