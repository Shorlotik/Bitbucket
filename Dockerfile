# Use a base image with Java 11
FROM openjdk:11-jre-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/rail-ninja-cli-1.0-SNAPSHOT.jar /app/app.jar

# Copy the .env file (will be overridden by docker-compose)
COPY .env.example /app/.env

# Run the application
CMD ["java", "-jar", "app.jar"]