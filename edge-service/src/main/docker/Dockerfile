FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD edge-service-*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9999
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]
