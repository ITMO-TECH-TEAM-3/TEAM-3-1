FROM maven:3.8.3-openjdk-16 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:16
COPY --from=build /usr/src/app/target/registration-0.0.1-SNAPSHOT.jar /usr/app/registration-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/registration-0.0.1-SNAPSHOT.jar"]
