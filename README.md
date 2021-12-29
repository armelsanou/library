# library
library management application based on a micro-services + springboot + restApi architecture

Library Rest Web Service with Spring boot for Backend
Download and unzip the project (intellij or eclipse workspace) but according to me, i suggest you tu use intellij as me

Importation
Under Eclipse : File -> Import -> Gradle ...

Under Intellij : open

Launching
Launch the main program: https://github.com/charroux/CarService/blob/master/src/main/java/com/example/CarRental/CarRentalApplication.java

Open a web browser to test the http get request: http://localhost:8080/cars

The Web Service
https://github.com/charroux/CarService/blob/master/src/main/java/com/example/CarRental/CarRentalService.java

Test with curl
Get a the list of books :

curl -X GET -i http://localhost:8080/api/livres

Add a new Book :

curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/api/livre --data '{"libelle":"Livre de Armel", "auteur": "armel", "idCategorie":1, "rent":false}'

