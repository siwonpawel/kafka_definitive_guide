FROM adoptopenjdk/openjdk14-openj9:alpine-slim
ADD /maven/consumer.jar .
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar consumer.jar"]