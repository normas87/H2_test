Do uruchomienia potrzebujemy:
JDK w wersji: 1.8

Aplikacja postawiona jest na porcie = 8080

Link aby dostać się do bazy danych H2:

localhost:8080/h2-console/

jdbc:h2:mem:base

User Name: sa

Password: nie ma, zostawiamy puste pole

curl aby dodać przykładową sale konferencyjną:

curl -X POST \
  http://localhost:8080/rooms \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: d7d45321-5ed2-48e7-9cb6-8c6096932672' \
  -H 'cache-control: no-cache' \
  -d '{
        "roomName": "Sala czerwona",
        "floor": 2,
        "available": true,
        "numberOfSeats": 40,
        "numberOfStandingPlaces": 30,
        "numberOfHangingPlaces": 2,
        "availablePhone": false
    }'
