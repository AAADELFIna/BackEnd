FROM eclipse-temurin:18
MAINTAINER ddoming
COPY build/libs/dd-back-0.0.1-SNAPSHOT.jar dd-back-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/dd-back-0.0.1-SNAPSHOT.jar"]