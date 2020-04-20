# Flight manager practical example

## Project structure

This project has 2 modules:
1. flight-api
1. flight-impl

The flight-api submodule contains the DTO and the API interface to be used by any Bytecode-compatible runtime to create 
a blocking client. Retrofit 1.x-2.x/RESTEasy/Jersey are some examples. This artifact could be imported as a library in
any app that requires a client of this microservice. 

The flight-impl submodule contains a microservice implemented with Spring Boot 2.x, using H2 embedded SQL server, JPA,
spring-data-jpa and written in Kotlin. The `kotlin-maven-plugin` is heavily used to open Kotlin classes that are 
final by default. Spring needs these classes opened to be able to create dynamic proxies. On the other hand JPA needs
entity classes to contains a parameterless constructor, something that Kotlin `data class` don't support.
This submodule contains a REST Controller (TicketResource), a service layer and a spring-data Repository.

## Run the microservice
1. Run `mvn spring-boot:run` at the parent project
1. The app will start at port 8080 by default.

## Request examples:

GET /tickets/{id}
```shell script
curl --location --request GET 'http://localhost:8080/tickets/1'
```

POST /tickets
```shell script
curl --location --request POST 'http://localhost:8080/tickets/' \
--header 'content: app' \
--header 'Content-Type: application/json' \
--data-raw '{
    "departureDate": "2020-10-19",
    "arrivalDate": "2020-10-19",
    "originCity": "Buenos Aires",
    "destinationCity": "Rosario",
    "passengerName": "Jorge Toselli",
    "passengerAge": 30,
    "hasLuggage": true,
    "price": 102.50,
    "departureTime": "08:50:00",
    "arrivalTime": "10:50:00"
}'
```

## Swagger 
Check: http://localhost:8080/swagger-ui.html#/ticket-resource
