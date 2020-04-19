# Flight manager practical example

Request examples:

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

# Swagger 
Check: http://localhost:8080/swagger-ui.html#/ticket-resource
