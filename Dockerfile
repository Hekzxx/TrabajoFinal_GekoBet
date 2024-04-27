FROM openjdk:18
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/gekobetv1-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} gekobetv1.jar
ENTRYPOINT ["java","-jar","/gekobetv1.jar"]