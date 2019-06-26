FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /tmp

COPY /backend.jar .
COPY /servers.json .
COPY /upload-dir .
COPY /launch.sh .

CMD ./launch.sh
#ENTRYPOINT ["java", "-jar", "backend.jar"]
