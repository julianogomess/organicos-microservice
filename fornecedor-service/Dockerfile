FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD /target/fornecedor-service-0.0.1-SNAPSHOT.jar fornecedor-service.jar
EXPOSE 8084
RUN bash -c 'touch /fornecedor-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:dev/./urandom","-jar", "/fornecedor-service.jar"]