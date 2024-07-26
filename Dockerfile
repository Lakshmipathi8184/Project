# Use an official base image with OpenJDK 8
FROM openjdk:8-jdk

# Set the working directory in the container
WORKDIR /app

# Copy your application JAR file into the container (if needed)
 COPY your-application.jar /app/

# Set environment variables (optional)
# ENV JAVA_OPTS="-Xmx512m"

# Run the application (if applicable)
CMD ["java", "-jar", "your-application.jar"]

# For now, just use the container to test Java installation
CMD ["java", "-version"]
