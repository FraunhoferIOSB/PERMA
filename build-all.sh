#!/usr/bin/env bash

# Requirements for running this script:
#    docker, maven

frontendVersion="0.0.2-SNAPSHOT"
# build backend
cd FROST-Client/FROST-Client-with_tasking_parameter_modelling/
mvn install
cd ../../backend/
./gradlew dockerPushImage --exclude-task test
cd ..


# build virtual actuator + virtual actuator server
cd FROST-Client/FROST-Client-without_tasking_parameter_modelling/
mvn install
cd ../../virtual_Actuator_+_virtual_Actuator-Server/
./gradlew installDist
./gradlew jar
./gradlew dockerPushImage
cd ..

# build frontend
cd frontend/
hash=$(git rev-parse --short HEAD)
docker build --tag fraunhoferiosb/perma:frontend-latest --build-arg HTTP_PROXY=$HTTP_PROXY --build-arg HTTPS_PROXY=$HTTP_PROXY .
docker tag fraunhoferiosb/perma:frontend-latest fraunhoferiosb/perma:frontend-$frontendVersion
docker tag fraunhoferiosb/perma:frontend-latest fraunhoferiosb/perma:frontend-$hash
docker push fraunhoferiosb/perma:frontend-latest
docker push fraunhoferiosb/perma:frontend-$frontendVersion
docker push fraunhoferiosb/perma:frontend-$hash
cd ..
