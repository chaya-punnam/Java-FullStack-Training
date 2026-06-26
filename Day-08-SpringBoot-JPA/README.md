=========================================
DAY 08 - SPRING BOOT & SPRING DATA JPA
======================================

1. What is Spring Framework?

---

Spring is a Java Framework used to develop enterprise applications.

## Features:

1. Dependency Injection
2. Aspect Oriented Programming
3. MVC Architecture
4. Transaction Management
5. Database Integration

=========================================
2. What is Spring Boot?
=======================

Spring Boot is an extension of Spring Framework.

## Advantages:

1. Faster Development
2. Auto Configuration
3. Embedded Server
4. Production Ready
5. Less Configuration

## Without Spring Boot:

Large XML Configuration

## With Spring Boot:

Minimal Configuration

=========================================
3. Spring Initializr
====================

## Website:

https://start.spring.io

## Project Settings:

Project Type : Maven

Language :
Java

Spring Boot Version :
4.1.0

Packaging :
Jar

Java Version :
17

## Dependencies:

1. Spring Data JPA
2. MySQL Driver

## After clicking GENERATE:

1. ZIP file downloaded.
2. Extract ZIP file.
3. Import into Eclipse as Maven Project.

=========================================
4. Maven Project Structure
==========================

## src/main/java

Contains Java Source Files

## src/main/resources

Contains application.properties

## pom.xml

Contains Dependencies

## target

Compiled Files

=========================================
5. Spring Data JPA
==================

Spring Data JPA is used to simplify database operations.

## Advantages:

1. No JDBC Code
2. No Hibernate Session Handling
3. Less Code
4. Built-in CRUD Operations

=========================================
6. Entity Class
===============

## Class:

FoodEntity.java

## Purpose:

Represents Database Table.

Annotations:

## @Entity

Marks class as Entity.

## @Table(name="foods")

Maps class to foods table.

## @Id

Represents Primary Key.

Example:

@Entity
@Table(name="foods")
public class FoodEntity {

```
@Id
private int foodID;

private String foodName;
private int foodCost;
private int foodRating;
```

}

=========================================
7. Repository Layer
===================

## Class:

FoodRepository.java

## Purpose:

Communicates with Database.

Code:

@Repository
public interface FoodRepository
extends JpaRepository<FoodEntity,Integer> {

}

## JpaRepository Provides:

1. save()
2. findAll()
3. findById()
4. deleteById()
5. count()
6. existsById()

=========================================
8. Service Layer
================

## Class:

FoodService.java

Annotation:

@Service

## Purpose:

Contains Business Logic.

Dependency Injection:

@Autowired
FoodRepository foodRepo;

=========================================
9. Insert Operation
===================

Method:

foodRepo.save(foodObject);

Example:

FoodEntity f1 = new FoodEntity();

f1.setFoodID(1);
f1.setFoodName("Idly");
f1.setFoodCost(100);
f1.setFoodRating(4);

foodRepo.save(f1);

## Output:

Data saved successfully.

=========================================
10. Read All Records
====================

Method:

foodRepo.findAll();

Example:

List<FoodEntity> foods =
foodRepo.findAll();

## Returns:

All records from foods table.

=========================================
11. Read Particular Record
==========================

Method:

foodRepo.findById(id);

Example:

FoodEntity food =
foodRepo.findById(2).get();

## Returns:

Food record with ID = 2

=========================================
12. Delete Record
=================

Method:

foodRepo.deleteById(id);

Example:

foodRepo.deleteById(2);

## Output:

Food deleted successfully.

=========================================
13. application.properties
==========================

## Purpose:

Stores Database Configuration.

Properties:

spring.application.name=
FirstSpringBootMavenProject

spring.datasource.url=
jdbc:mysql://localhost:3306/food_db

spring.datasource.username=root

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

server.port=9999

spring.jpa.properties.hibernate.dialect=
org.hibernate.dialect.MySQLDialect

=========================================
14. hibernate.ddl-auto
======================

## update

Updates existing tables.

## create

Drops old table and creates new table.

## create-drop

Creates and deletes table.

## validate

Validates schema.

=========================================
15. Common JPA Methods
======================

## save()

Insert / Update

## findAll()

Read all records

## findById()

Read particular record

## deleteById()

Delete record

## count()

Count records

## existsById()

Check record exists

=========================================
16. Spring Boot Workflow
========================

Entity
|
Repository
|
Service
|
Database

=========================================
17. Interview Questions
=======================

Q1. What is Spring Boot?

A:
Spring Boot is a framework used to develop Java applications with minimum configuration.

---

Q2. What is Spring Data JPA?

A:
Spring Data JPA simplifies database operations using repositories.

---

Q3. What is @Entity?

A:
Used to map Java class with database table.

---

Q4. What is @Table?

A:
Used to specify table name.

---

Q5. What is @Id?

A:
Represents Primary Key.

---

Q6. What is JpaRepository?

A:
Provides built-in CRUD methods.

---

Q7. What is @Autowired?

A:
Used for Dependency Injection.

---

Q8. What is @Service?

A:
Marks a class as Service Layer.

---

Q9. Difference between Hibernate and Spring Data JPA?

## Hibernate:

Need SessionFactory, Session.

## Spring Data JPA:

Uses Repository Interface.

Less code.

---

Q10. What is application.properties?

A:
Stores application configuration.

=========================================
TOPICS COVERED
==============

1. Spring Initializr
2. Maven Project
3. Spring Boot
4. Spring Data JPA
5. Entity Class
6. Repository Layer
7. Service Layer
8. CRUD Operations
9. application.properties
10. Dependency Injection

=========================================
END OF DAY 08
=============
