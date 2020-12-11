FROM openjdk:8
EXPOSE 9091
ADD target/fare-service-springboot-mysql.jar fare-service-springboot-mysql.jar
ENTRYPOINT ["java","-jar","/fare-service-springboot-mysql.jar"]