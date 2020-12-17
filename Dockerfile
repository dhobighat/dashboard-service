FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-debian
VOLUME /tmp
ADD target/dependency/jacocoagent.jar jacocoagent.jar
ADD target/dashboard-service*.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar