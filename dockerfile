FROM maven:3.6.3-jdk-11 as build
RUN mkdir -p /root/.m2 \
    && mkdir /root/.m2/repository
COPY settings.xml /root/.m2
WORKDIR /workspace
COPY pom.xml pom.xml
COPY base base
COPY api api
COPY logger logger
COPY service service
COPY repository repository
COPY web-api web-api
COPY web-app web-app
RUN mvn package -P stage

FROM openjdk:11
WORKDIR /workspace
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8090
COPY --from=build /workspace/web-api/target/erp-web-api.jar erp-web-api.jar
ENTRYPOINT ["java", "-jar", "erp-web-api.jar"]
EXPOSE 8080
EXPOSE 8090