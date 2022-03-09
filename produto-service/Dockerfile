FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD /target/produto-service-0.0.1-SNAPSHOT.jar produto-service.jar
EXPOSE 8083
RUN bash -c 'touch /produto-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:dev/./urandom","-jar", "/produto-service.jar"]