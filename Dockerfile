# Definizione di Alias
FROM maven:3.6.3-jdk-11-slim AS build
# Creazione cartella di lavoro
RUN mkdir -p /workspace
# Working Directiory
WORKDIR /workspace
# Creazione del package
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests
FROM openjdk:11-jdk-slim
COPY --from=build /workspace/target/*.jar app.jar
# This allows Heroku bind its PORT the Apps port
# since Heroku needs to use its own PORT before the App can be made accessible to the World
EXPOSE $PORT
# Commandi di start
ENTRYPOINT ["java","-jar","app.jar"]