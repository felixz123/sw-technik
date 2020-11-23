#!/bin/bash
#Erstelle .jar datei
mvn package

#Erstelle docker image wie in 'dockerfile' beschrieben
docker build -t zulassungssystemteamgreen .
#Starte container und leite Container-Port 8080 auf Host-Port 80
docker run -p 80:8080 --name zulassungssystem zulassungssystemteamgreen
