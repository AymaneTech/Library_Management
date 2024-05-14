# Makefile for a Maven project

# Project name (replace with your project name)
PROJECT_NAME=Library_Management

# Maven command
MVN=mvn

# Project main class (replace with your main class)
MAIN_CLASS=yc.geek.Main

# Targets
.PHONY: all compile test package run clean

all: compile test package

compile:
	$(MVN) compile

test:
	$(MVN) test

package:
	$(MVN) package

run:
	java -cp target/$(PROJECT_NAME)-1.0-SNAPSHOT.jar $(MAIN_CLASS)

clean:
	$(MVN) clean

