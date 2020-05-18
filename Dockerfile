FROM openjdk:14

RUN mkdir -p /app
COPY ./build/libs/agh-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app