# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy project files
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the application (skip tests to speed up build)
RUN ./mvnw clean package -DskipTests

# Run the JAR file
CMD ["java", "-jar", "target/Tourism.Diary-0.0.1-SNAPSHOT.jar"]
