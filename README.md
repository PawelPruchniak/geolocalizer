I have created a basic REST service using Java and Spring Boot. 
As a database I used hsql database stored in local memory,
for requests security and login I used basic Spring Security configuration,
where user is "user" and password is always generated at application startup.

Application is able to save, delete, and retrieve a list of geo locations and devices.

List of requests:
GET all objects - localhost:8080/api/devices, localhost:8080/api/localizations
GET one by Id   - localhost:8080/api/device/{id}, localhost:8080/api/localization/{id}
POST new object - localhost:8080/api/device, localhost:8080/api/localization
DELETE by Id    - localhost:8080/api/device/{id}, localhost:8080/api/localization/{id}
