#!/bin/sh

cd discovery-service; ./gradlew clean build buildDocker; cd ..
cd address-service; ./gradlew clean build buildDocker; cd ..
cd edge-service; ./gradlew clean build buildDocker; cd ..
cd hystrix-dashboard; ./gradlew clean build buildDocker; cd ..
cd turbine; ./gradlew clean build buildDocker; cd ..
