FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/library.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
