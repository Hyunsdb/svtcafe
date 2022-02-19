#베이스 이미지, 빌드할 이미지가 어떤 이미지를 기반으로 하고 있는지 나타냄, jre11 이미지를 기반으로 하겠다는 의미
FROM openjdk:11.0.10-jre-slim-buster

ARG JAR_FILE=build/libs/*.jar

#파일을 이미지에 추가하겠다는 것을 의미.
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
