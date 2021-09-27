# people-list-h2
People-list project with embedded H2 database

## Description
people-list project with CRUD operations impacting a H2 embedded database.

## Design
Basic Spring application with 3 controllers, developed with the goal to help aspiring Spring developers to learn basic Spring features.
Includes:
- Java 15
- Spring MVC
- Spring Boot
- Spring Boot Test
- Mockito for MVC unit testing
- Project Lombok
- OpenApi UI to test the app
- Embedded H2 database
- GET, PUT, POST, DELETE and PATCH methods for all entities.

## Using the app
In order to test the app, you have to build the JAR file and execute it

To build the app without tests, run:

```bash
 mvn clean install -DskipTests=true
```

And then execute
```bash
java -jar people-list-h2/target/people-list-h2-1.0-SNAPSHOT.jar
```

This will start the Spring Boot app and H2 database. You can test the connection to the DB with any client or with the embedded H2 console, available on http://localhost:8080/h2/

Credentials can be found on the [application.properties](https://github.com/mauroalfaro/people-list-h2/blob/main/src/main/resources/application.properties)  file. You can change username and password (and also console url) if you want to.

Property spring.datasource.initialization-mode is set to always, so everytime you restart the app the DB will be swiped. Change this property if you want to keep your info after stopping the application.

The API provides endpoints for the three models available: Customers, Employees and Stores. Providing CRUD operations. 
You can check the Swagger UI for documentation about these endpoints and model examples hitting http://localhost:8080/swagger-ui.html
Go to http://localhost:8080/v3/api-docs/ to check the entire OpenApi documentation.


## Run the tests
Run
```bash
mvn clean test
```
