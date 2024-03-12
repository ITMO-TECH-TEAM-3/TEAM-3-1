#!/bin/bash

flyway migrate -url=jdbc:postgresql://postgres:5432/registration -user=aboba -password=aboba

java -jar target/registration-0.0.1-SNAPSHOT.jar