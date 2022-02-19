FROM adoptopenjdk/openjdk14-openj9:alpine-slim
ADD /maven/producer.jar .
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar producer.jar"]