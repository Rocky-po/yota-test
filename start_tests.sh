#!/bin/bash

mvn clean package install
javac OpenReport.java
java OpenReport
rm OpenReport.class
