FROM java:8-jdk-alpine

COPY /target/Project2-0.0.1-SNAPSHOT.jar /Project2-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","Project2-0.0.1-SNAPSHOT.jar"]
