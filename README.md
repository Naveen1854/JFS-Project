# JFS-Project

Project Title
-------------
HOSPITAL MANAGEMENT SYSTEM

✅Project Description
-------------------
This is a Spring Boot based Hospital Management System that helps manage hospital operations like patient records, doctor details, appointments, and other administrative tasks.
The application follows a layered architecture using Controller, Service, Repository, Entity, and DTO.


✅Technologies Used
------------------
Java
Spring Boot
Spring Data JPA
Hibernate
MySQL
Maven
REST API
Postman (for testing)


✅Project Architecture
---------------------
Controller → Service → DTO → Entity → Repository → Database
This structure helps in separating business logic and database logic, improving maintainability.


✅Features
--------
Add, update, delete patient records
Manage doctor details
RESTful API implementation
DTO pattern used to protect sensitive data
Exception handling
Layered architecture


✅How to Run the Project
----------------------
1. Clone the repository
     ✨ git clone https://github.com/Naveen1854/JFS-Project.git
2. Open in IDE (IntelliJ / Eclipse / STS)
3. Configure database in application.properties
4. Run the Spring Boot application


✅Database Configuration Example
------------------------------
spring.application.name=hospital-management-system

#1. database
spring.datasource.url=jdbc:mysql://localhost:3306/hospitaldb?createDatabaseIfNotExist=true

spring.datasource.username=root

spring.datasource.password=yourpassword

#2. hibernate
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

#3. server
server.port=8181

#4. console
spring.output.ansi.enabled=always


✅API Testing
-----------
You can test APIs using Postman.

✅Purpose of the Project
----------------------
This project was built to practice Spring Boot REST API development and understand real-world backend architecture.
