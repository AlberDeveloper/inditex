FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD target/inditex-service-price.jar inditex-service-price.jar
ENTRYPOINT ["java", "-jar", "inditex-service-price.jar"]
