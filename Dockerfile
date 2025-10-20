# Stage 1: Build the application
FROM maven:3.9.5-eclipse-temurin-21 AS builder

# Set working directory
WORKDIR /app

# Copy all files
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
# Use a JDK 21 image for the runtime environment
FROM eclipse-temurin:21-jdk-alpine

# Set working directory in the container
WORKDIR /app

# Copy JAR from the builder stage
COPY --from=builder /app/target/simple-todo-*.jar app.jar

# Expose port (optional - depends on your application port)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]