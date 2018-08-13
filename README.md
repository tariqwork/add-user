# Application
Spring Boot RESTful web application to add user into MySQL Database 

# Overview
This is a Spring Boot web application, implementing RESTful web services to add a user into MySQL database with validation the input JSON and suitable response. 

Validation Requirements:
•	username, firstname, lastname and age are required
•	username, firstname and lastname are Strings with maximum length of 50 characters
•	age is an integer and cannot be negative


# Prerequisites
Java 1.8
Maven 3.5.3
MySQL database with table user with 4 columns username, firstname, lastname and age

# MySQL database configuration
Database configurations can be change into application.yml file
e.g. URL, user name and password

# Build the maven project
Maven is used as a build tool. Please use the following command to build the project:

mvn clean package 

# Run the application On Windows OS
To run the application on Windows OS. Please use the following command. This command will also start the embedded tomcat as a backend server on port 8080.

java -jar add-user-1.0.0-SNAPSHOT.jar

# Call the RESTful Service
After successfully run the backend server. Use any REST Client to call the REST Service as follow:


POST http://localhost:8080/contactapi/user/add
Content-Type: application/json
body:
{
	"username": "TestUser1",
	"firstname": "John",
	"lastname": "Li",
	"age": 25
}

# Possible responses of RESTful
201   Created                 User has been successfully added
409   Conflict                User name already exist
400   Bad Request             Validation Failed
500   Internal Server Error   Internal application error

# Additional Info






