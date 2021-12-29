# library
library management application based on a micro-services + springboot + restApi architecture

Library Rest Web Service with Spring boot for Backend
Download and unzip the project (intellij or eclipse workspace) but according to me, i suggest you tu use intellij as me

Importation
Under Eclipse : File -> Import -> Gradle ...

Under Intellij : open

After opening, you can change the port into file application.properties

Launching
Launch the main program: https://github.com/armelsanou/library/blob/main/src/main/java/com/library/LibraryApplication.java

Open a web browser to test the http get request: http://localhost:8081/cars

The Web Service
https://github.com/armelsanou/library/blob/main/src/main/java/com/library/controllers/

Test with curl
Get a the list of books :

curl -X GET -i http://localhost:8081/api/livres

Add a new Book :

curl -X POST -H 'Content-Type: application/json' -i http://localhost:8081/api/livre --data '{"libelle":"Livre de Armel", "auteur": "armel", "idCategorie":1}'

Get a book 

http://localhost:8081/api/livre/1
