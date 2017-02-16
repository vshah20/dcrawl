#!/bin/bash

cd DC1
javac -cp "jsoup-1.8.3.jar" *.java
cd ../DC2
javac -cp "jsoup-1.8.3.jar" *.java
cd ../DC3
javac -cp "jsoup-1.8.3.jar" *.java
cd ../DC4
javac -cp "jsoup-1.8.3.jar" *.java
cd ../DC5
javac -cp "jsoup-1.8.3.jar" *.java
cd ..
