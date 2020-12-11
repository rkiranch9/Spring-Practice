FROM openjdk:8
EXPOSE 9091
ADD target/fare-service.jar fare-service.jar
ENTRYPOINT ["java","-jar","/fare-service.jar"]