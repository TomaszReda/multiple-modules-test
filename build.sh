#!/bin/bash
mvn clean install
cd docker
docker-compose down && docker-compose build && docker-compose up -d