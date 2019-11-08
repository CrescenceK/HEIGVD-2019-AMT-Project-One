#! /bin/bash

mvn clean install

cp target/gestionCours.war images/glassfish/
docker-compose down
docker-compose up --build 