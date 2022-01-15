FROM mdsol/java11-jdk
VOLUME /tmp
EXPOSE 8081
ADD ./build/libs/library.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["./wait-for-it.sh", "db:3306", "--", "java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
