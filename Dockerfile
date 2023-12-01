# Use an official Java runtime as the base image
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle

# Copy the application source code
COPY src /app/src

# Build the application using Gradle
RUN ./gradlew build

# Expose the port on which the application will run
EXPOSE 8080

# Set the command to run the application
CMD ["java", "-jar", "/app/build/libs/demo-1.0.0.jar"]
