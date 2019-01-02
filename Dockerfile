FROM alpine:edge
RUN apk add --no-cache openjdk8
COPY files/UnlimitedJCEPolicyJDK8/* /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/
COPY target/todo-list-service-0.0.1-SNAPSHOT.jar /app.jar
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]
