# Spring Data JPA Entity Mapping Project

This project demonstrates entity mapping using Spring Boot and Spring Data JPA. It establishes a One-to-Many and Many-to-One relationship between the Employee and Address classes.

## Project Description

The project consists of two main classes representing an employee (Employee) and the employee's addresses (Address). Using Spring Data JPA, a relationship is established between these two classes. The project allows saving and retrieving employee and address information from the database based on this relationship.

## Technologies

- Java 20
- Spring Boot = 3.1.5
- Spring Data JPA
- Lombok
- Hibernate

## Installation

1. Clone the project to your computer:

   ```bash
   git clone https://github.com/username/project-name.git
   ```

2. Navigate to the project directory:

   ```bash
   cd project-name
   ```

3. Start the project:

   ```bash
   ./mvnw spring-boot:run
   ```

   or

   ```bash
   mvn spring-boot:run
   ```

4. Open your browser and go to [http://localhost:8080](http://localhost:8080).

## Usage

After starting the project, you can explore the APIs through Swagger UI at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

- `/employees`: Retrieves all employee information.
- `/addresses`: Retrieves all address information.


## Some Screenshots from POSTMAN

![image](https://github.com/yusufbgdd557/Spring-Data-JPA-Entity-Mapping/assets/45573977/21bd075b-2c64-41e0-8aaf-d25e83cf6ae6)

![image](https://github.com/yusufbgdd557/Spring-Data-JPA-Entity-Mapping/assets/45573977/b9c93813-629b-4740-86da-647bc4461659)

