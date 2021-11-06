FROM maven:3.6.3-jdk-8-slim AS build
ENV HOME=/home/app
RUN mkdir -p $HOME
WORKDIR $HOME

# 1. add pom.xml only here
ADD pom.xml $HOME

# 2. start downloading dependencies
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]

# 3. add all source code and start compiling
ADD . $HOME

RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY --from=build /home/app/target/*.jar customers.jar
ENTRYPOINT [ "sh", "-c", "java -jar /customers.jar"]
