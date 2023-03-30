FROM adoptopenjdk/openjdk11:jre-11.0.9_11.1-alpine
WORKDIR /app/
ARG JAR_FILE
COPY target/${JAR_FILE} homework1.jar
ENTRYPOINT [ "java", "-jar", "homework1.jar" ]
EXPOSE 8000