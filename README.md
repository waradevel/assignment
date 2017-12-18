# assignment

Spring boot, framework used to implement the project


#Insert a Class

METHOD: POST, Content-Type=application/json

localhost:8080/classes

body example
{
    "code": "MAT103",
    "title": "Mathematics-103",
    "description": "mat description"
}

#Insert a Student

Method: POST, Content-Type=application/json

localhost:8080/students
body example

{
    "firstName": "Johnn",
    "lastName": "Smith"
}

# GET methods

Get all classes
localhost:8080/classes

Get one class by id 0
localhost:8080/classes/0

Get all students
localhost:8080/students

Get one student by id 1
localhost:8080/students/1


#Assign a student to a class

Method: POST
In the below example the student with id 3 is being assigned to class with id 1
localhost:8080/classes/1/student/3

#Requirements
java 1.8

#Notes
Ids for entities are auto generated.

Compiling and running
mvn clean package && java -jar target/assignment-0.0.1-SNAPSHOT.jar

Just running, there is a jar file in the base path that you can run with the below command, no need to compile

java -jar assignment-0.0.1-SNAPSHOT.jar