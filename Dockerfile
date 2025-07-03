# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and build files
COPY mvnw pom.xml ./
COPY wrapper/ ./wrapper/
COPY maven-wrapper.jar ./  # if needed in root
COPY maven-wrapper.properties ./  # if needed in root

# Point to the custom wrapper directory (not ideal, but functional)
ENV MAVEN_WRAPPER_LAUNCHER=wrapper/MavenWrapperDownloader.java
ENV MAVEN_OPTS="-Dmaven.wrapper.defaultUrl=https://repo.maven.apache.org/maven2"

# Ensure Maven wrapper can run
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw -Dmaven.repo.local=/root/.m2 dependency:go-offline

# Copy source code
COPY src ./src

# Build the application (skip tests for speed)
RUN ./mvnw package -DskipTests

# Replace this with your actual JAR name in target/
ENTRYPOINT ["java", "-jar", "target/your-app-name.jar"]
