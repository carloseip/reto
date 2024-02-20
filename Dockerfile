FROM maven:3.9.3-eclipse-temurin-17-alpine AS MAVEN_BUILD

MAINTAINER Carlos IP

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn clean package -DskipTests

FROM amazoncorretto:17

WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/reto-1.0.jar /app/

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "reto-1.0.jar"]