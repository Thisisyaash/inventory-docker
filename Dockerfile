FROM amazoncorretto:17

MAINTAINER YASH

WORKDIR /usr/src/myapp

COPY target/inventory-management-0.0.1-SNAPSHOT.jar /usr/src/myapp

EXPOSE 8080

CMD ["java","-jar","inventory-management-0.0.1-SNAPSHOT.jar"]