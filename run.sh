#!/usr/bin/env bash

pushd swagger
    mvn clean package install
popd
pushd main
    mvn clean spring-boot:run
popd