#FROM maven:3.8.5-openjdk-17
#
FROM eclipse-temurin:17
WORKDIR /mean-app
#COPY . .
#RUN mvn clean install
#
#CMD mvn spring-boot:run

# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8090

# Run the App
ENTRYPOINT ["java","-jar", "/mean-app/app.jar"]