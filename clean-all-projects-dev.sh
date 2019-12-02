#!/bin/sh

cd discovery-service; ./gradlew clean ; cd ..
cd edge-service; ./gradlew clean ; cd ..
cd address-service; ./gradlew clean ; cd ..
