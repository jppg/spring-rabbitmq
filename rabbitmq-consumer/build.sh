#!/bin/bash

echo "Performing a clean Maven build"
./mvnw clean package -DskipTests=true

echo "Building the RabbitMQ Consumer"
docker build --tag rabbitmq-consumer-test .