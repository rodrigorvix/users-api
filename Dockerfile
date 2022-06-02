FROM openjdk:11

COPY ./build/libs/users-api-0.0.1-SNAPSHOT.jar users-api-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "users-api-0.0.1-SNAPSHOT.jar"]