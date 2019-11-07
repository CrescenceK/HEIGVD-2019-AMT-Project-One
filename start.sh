#! /bin/bash
mvn clean install

cp target/gestionCours.war images/glassfish/
pwd
docker-compose down
docker-compose up --build glassfish