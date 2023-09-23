FROM openjdk:17-jdk-slim
VOLUME /tmp                   # Temporary location to run
EXPOSE 8080                   # Provide port number
ADD target/Szoftverfejlesztes-mernokoknek-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","--server.port=8181"]y