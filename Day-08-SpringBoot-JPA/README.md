# 📅 Day 08 – Spring Boot & Spring Data JPA

## 📌 Overview

On Day 08, I learned the fundamentals of **Spring Boot** and **Spring Data JPA**. I explored how Spring Boot simplifies Java application development with minimal configuration and how Spring Data JPA provides built-in CRUD operations without writing JDBC or Hibernate session management code. I also created a Spring Boot Maven project, configured database connectivity, and performed database operations using JPA repositories.

---

# 📚 Topics Covered

* Introduction to Spring Framework
* Spring Boot
* Spring Initializr
* Maven Project Structure
* Spring Data JPA
* Entity Class
* Repository Layer
* Service Layer
* CRUD Operations
* `application.properties`
* Hibernate DDL Auto
* Dependency Injection
* Built-in JPA Methods

---

# 🛠 Technologies Used

## Backend

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Tools

* Eclipse IDE
* Spring Initializr
* MySQL Workbench
* Maven

---

# 🚀 Spring Boot Project Creation

## Spring Initializr

Website:

```text
https://start.spring.io
```

### Project Configuration

| Property     | Value |
| ------------ | ----- |
| Project      | Maven |
| Language     | Java  |
| Spring Boot  | 4.1.0 |
| Packaging    | Jar   |
| Java Version | 17    |

### Dependencies

* Spring Data JPA
* MySQL Driver

### Steps

1. Generate the project.
2. Download the ZIP file.
3. Extract the project.
4. Import into Eclipse as a Maven Project.

---

# 📂 Maven Project Structure

```text
FirstSpringBootMavenProject/
│── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │        └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── target/
```

---

# 🌱 What is Spring Framework?

Spring is a Java Framework used to develop enterprise applications.

### Features

* Dependency Injection
* Aspect Oriented Programming (AOP)
* MVC Architecture
* Transaction Management
* Database Integration

---

# 🚀 What is Spring Boot?

Spring Boot is an extension of the Spring Framework that simplifies application development by providing auto-configuration and an embedded server.

### Advantages

* Faster Development
* Auto Configuration
* Embedded Server
* Production Ready
* Less Configuration

### Without Spring Boot

```text
Large XML Configuration
```

### With Spring Boot

```text
Minimal Configuration
```

---

# 💾 Spring Data JPA

Spring Data JPA simplifies database operations using repository interfaces.

### Advantages

* No JDBC Code
* No Hibernate Session Handling
* Less Boilerplate Code
* Built-in CRUD Operations

---

# 🗂 Entity Class

Entity Class:

```text
FoodEntity.java
```

### Purpose

Represents a database table.

### Annotations Used

* `@Entity`
* `@Table`
* `@Id`

### Example

```java
@Entity
@Table(name = "foods")
public class FoodEntity {

    @Id
    private int foodID;

    private String foodName;
    private int foodCost;
    private int foodRating;
}
```

---

# 📦 Repository Layer

Repository Interface:

```text
FoodRepository.java
```

### Annotation

```java
@Repository
```

### Example

```java
@Repository
public interface FoodRepository
extends JpaRepository<FoodEntity, Integer> {

}
```

### JpaRepository Methods

* `save()`
* `findAll()`
* `findById()`
* `deleteById()`
* `count()`
* `existsById()`

---

# ⚙️ Service Layer

Service Class:

```text
FoodService.java
```

### Annotation

```java
@Service
```

### Dependency Injection

```java
@Autowired
private FoodRepository foodRepo;
```

### Purpose

Contains business logic and communicates with the repository layer.

---

# ➕ Insert Operation

Method

```java
foodRepo.save(foodObject);
```

### Example

```java
FoodEntity f1 = new FoodEntity();

f1.setFoodID(1);
f1.setFoodName("Idly");
f1.setFoodCost(100);
f1.setFoodRating(4);

foodRepo.save(f1);
```

### Output

```text
Data Saved Successfully
```

---

# 📖 Read All Records

Method

```java
foodRepo.findAll();
```

### Example

```java
List<FoodEntity> foods = foodRepo.findAll();
```

Returns all records from the database.

---

# 🔍 Read Particular Record

Method

```java
foodRepo.findById(id);
```

### Example

```java
FoodEntity food =
foodRepo.findById(2).get();
```

Returns the food record with the given ID.

---

# ❌ Delete Record

Method

```java
foodRepo.deleteById(id);
```

### Example

```java
foodRepo.deleteById(2);
```

Deletes the specified record from the database.

---

# ⚙️ application.properties

Stores application and database configuration.

### Example

```properties
spring.application.name=FirstSpringBootMavenProject

spring.datasource.url=jdbc:mysql://localhost:3306/food_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=9999

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

# 🗄 Hibernate DDL Auto

| Option      | Description                                |
| ----------- | ------------------------------------------ |
| update      | Updates existing tables                    |
| create      | Drops old tables and creates new ones      |
| create-drop | Creates and deletes tables after execution |
| validate    | Validates schema                           |

---

# 📚 Common JPA Repository Methods

| Method         | Purpose                |
| -------------- | ---------------------- |
| `save()`       | Insert / Update        |
| `findAll()`    | Read All Records       |
| `findById()`   | Read Particular Record |
| `deleteById()` | Delete Record          |
| `count()`      | Count Records          |
| `existsById()` | Check Record Existence |

---

# 🔄 Spring Boot Workflow

```text
Entity
   │
   ▼
Repository
   │
   ▼
Service
   │
   ▼
Database
```

---

# 🎯 Learning Outcomes

By completing this task, I learned how to:

* Create Spring Boot applications using Spring Initializr.
* Configure Maven-based Spring Boot projects.
* Use Spring Data JPA for database operations.
* Create Entity classes using JPA annotations.
* Implement Repository and Service layers.
* Perform CRUD operations using `JpaRepository`.
* Configure database connectivity using `application.properties`.
* Understand the Spring Boot application architecture.

---



### 1. What is Spring Boot?

Spring Boot is a framework that simplifies Java application development using minimal configuration.

### 2. What is Spring Data JPA?

Spring Data JPA simplifies database operations using repository interfaces.

### 3. What is `@Entity`?

Maps a Java class to a database table.

### 4. What is `@Table`?

Specifies the database table name.

### 5. What is `@Id`?

Represents the Primary Key of an entity.

### 6. What is `JpaRepository`?

Provides built-in CRUD methods for database operations.

### 7. What is `@Autowired`?

Used for Dependency Injection.

### 8. What is `@Service`?

Marks a class as the Service Layer containing business logic.

### 9. Difference between Hibernate and Spring Data JPA?

**Hibernate**

* Uses `SessionFactory` and `Session`
* Requires more configuration

**Spring Data JPA**

* Uses `JpaRepository`
* Less code and easier CRUD operations

### 10. What is `application.properties`?

Stores application and database configuration properties.

---

# 📖 Topics Covered Summary

* Spring Initializr
* Maven Project
* Spring Boot
* Spring Data JPA
* Entity Class
* Repository Layer
* Service Layer
* CRUD Operations
* application.properties
* Dependency Injection

---

# 🚀 Day 08 Summary

✅ Learned the fundamentals of **Spring Framework** and **Spring Boot**.

✅ Created a **Spring Boot Maven Project** using Spring Initializr.

✅ Configured **Spring Data JPA** with MySQL.

✅ Created **Entity**, **Repository**, and **Service** layers.

✅ Performed CRUD operations using `JpaRepository`.

✅ Configured the application using `application.properties`.

✅ Understood the complete Spring Boot application workflow.
