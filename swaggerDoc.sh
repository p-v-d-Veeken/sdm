#!/usr/bin/env bash

pushd swagger
    mvn clean swagger2markup:convertSwagger2markup
popd