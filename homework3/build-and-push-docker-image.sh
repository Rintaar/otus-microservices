#!/bin/bash
set -e
mvn -f ./pom.xml dockerfile:build dockerfile:tag dockerfile:push