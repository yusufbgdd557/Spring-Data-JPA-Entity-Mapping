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

## Code Snippets

```java
@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
@JsonManagedReference
private List<Address> addresses;
```

1. `@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)`: This annotation is used to define a one-to-many relationship between the `Employee` entity and the `Address` entity. It signifies that an employee can have multiple addresses. The `mappedBy` attribute is used to specify the field in the `Address` entity that owns the relationship, and in this case, it is the "employee" field in the `Address` entity.

2. `@JsonManagedReference`: This annotation is part of the Jackson library, which is used for JSON serialization and deserialization in Java. In the context of a bidirectional relationship (like one-to-many), it helps to handle the infinite recursion problem during the serialization process. 

   - In a bidirectional relationship, if both `Employee` and `Address` classes have references to each other, when you try to serialize an `Employee` object, it will also try to serialize the associated `Address` objects. However, each `Address` object, in turn, has a reference back to the `Employee` object, creating a loop, which can lead to a StackOverflowError during serialization.
   
   - `@JsonManagedReference` is placed on the "owner" side of the relationship, which is the `addresses` field in the `Employee` class in this case. It tells Jackson to serialize this side of the relationship and ignore the other side (`@JsonBackReference` is typically used on the other side).

By using `@JsonManagedReference` in combination with `@JsonBackReference` on the corresponding field in the `Address` class, you can prevent this infinite loop during JSON serialization and avoid issues like StackOverflowError.


```java
@ManyToOne
@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
@JsonBackReference
private Employee employee;
```

1. `@ManyToOne`: This annotation is used to define a many-to-one relationship between the `Address` entity and the `Employee` entity. It signifies that many addresses can be associated with one employee. This is the reverse side of the one-to-many relationship defined in the `Employee` class.

2. `@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")`: This annotation is used to specify the foreign key column in the `Address` table that is used to maintain the association with the `Employee` table. In this case, it's saying that the `emp_id` column in the `Address` table should be used as the foreign key, referencing the `emp_id` column in the `Employee` table.

3. `@JsonBackReference`: Similar to `@JsonManagedReference`, this annotation is part of the Jackson library and is used to handle the infinite recursion problem during JSON serialization. In a bidirectional relationship, it marks the "back" side of the relationship (the owning side is marked with `@JsonManagedReference`). It tells Jackson to ignore this side during serialization to avoid circular references.

   - In this context, when you serialize an `Address` object, it will include information about the associated `Employee`, but the `Employee` object won't be serialized again to prevent the circular reference.

By using `@JsonBackReference` in combination with `@JsonManagedReference` on the other side of the relationship, you effectively manage bidirectional relationships during JSON serialization, preventing infinite loops and ensuring a clean and concise representation of your data.

## Some Screenshots from POSTMAN

![image](https://github.com/yusufbgdd557/Spring-Data-JPA-Entity-Mapping/assets/45573977/21bd075b-2c64-41e0-8aaf-d25e83cf6ae6)

![image](https://github.com/yusufbgdd557/Spring-Data-JPA-Entity-Mapping/assets/45573977/b9c93813-629b-4740-86da-647bc4461659)

