FROM adoptopenjdk:11-jre-hotspot
COPY target/rabbitmq-consumer-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 9003