FROM openjdk:11

ARG APP_NAME
EXPOSE 8081

COPY target/$APP_NAME /opt/app.jar
CMD java -jar /opt/app.jar