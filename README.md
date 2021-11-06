# customers-api


Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application locally you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application using Docker

There are several ways to run a Spring Boot application on your local machine.One way is to start the application using Docker:-
```shell
docker-compose up
```
By default will make the application accessible outside the container on http://localhost:8082

## To Run the Tests
* Create empty postgres db for the testing purposes.
* Add the db info in test/application.properties.
