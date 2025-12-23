FROM eclipse-temurin:17-jdk-alpine

ADD target/recipe-api-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]