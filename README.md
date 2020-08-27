# Platform:
* Build tool used Maven
* TestNG testing framework
* Java and Selenium CodeBase
* Cucumber BDD

# How to run:
1. Open Command Line and Go To Your Project Folder
2. Run WebTest only - mvn test -Dcucumber.options="--tag @WebTest"
3. Run APITest only - mvn test -Dcucumber.options="--tag @APITest"
4. Run All - mvn test

# Project Files:
* POM: ./pom.xml
* Feature file: ./src/test/resources/features/Exam.feature
* Step Definition: ./src/test/java/NKuhutan/TSB/StepDefs/Steps.java
* Runner Class: ./src/test/java/NKuhutan/TSB/Runners/RunnerTest.java
* And all other files the usual

# Note:
I'm always using "2010 Audi A3" as a search text (including "Audi" as the make for API).
You can change that for desired value.
But this record has incomplete key details thus, my test is capturing that assertion failure - that makes it valid
