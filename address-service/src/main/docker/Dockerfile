FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD address-service-*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9200
#ENV SPRING_PROFILES_ACTIVE docker
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]
