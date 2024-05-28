# Use the OpenJDK 17 JDK Alpine base image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file from the target directory
COPY target/*.jar /app/

# Set the command to run your Java application
CMD ["java", "-jar", "/app/testimage.jar"]







# Use an official OpenJDK runtime as a parent image
#FROM openjdk:11-jdk-slim

# Label the maintainer of the image
#LABEL authors="amirdi"

# Set the working directory in the container
#WORKDIR /app

# Copy the current directory contents into the container at /app
#COPY . /app

# Download necessary JAR files for JUnit 5 and Hamcrest
#RUN apt-get update && \
 #   apt-get install -y wget && \
  #  wget -O junit-platform-console-standalone-1.8.2.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.2/junit-platform-console-standalone-1.8.2.jar

# Ensure the source files are in the /app directory
#RUN ls -la /app

# Print the contents of the app directory for debugging
#RUN echo "Listing /app directory:" && ls -R /app

# Compile the application
#RUN javac -cp .:/app/junit-platform-console-standalone-1.8.2.jar /app/src/main/java/Account.java /app/src/test/java/AccountTest.java

# Define the command to run the application
#CMD ["java", "-jar", "junit-platform-console-standalone-1.8.2.jar", "-cp", "/app/src/main/java:/app/src/test/java", "--scan-classpath"]
