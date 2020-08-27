# Platform:
* Build tool used Maven
* TestNG testing framework
* Java and Selenium CodeBase

# How to run:
1. Open Command Line and Go To Your Project Folder
2. Run WebTest only - mvn test -Dcucumber.options="--tag @WebTest"
3. Run APITest only - mvn test -Dcucumber.options="--tag @APITest"
4. Run All - mvn test