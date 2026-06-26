# 📅 Day 09 – Spring Boot REST API Project (Doctor Management System)

## 📌 Overview

On Day 09, I learned how to build a **Spring Boot REST API** by developing a **Doctor Management System**. I explored the REST architecture, HTTP methods, layered architecture (Controller, Service, Repository, Entity), request validation, dependency injection, and CRUD operations. I also tested the REST APIs using **Postman** and connected the application to a **MySQL** database.

---

# 📚 Topics Covered

* Introduction to REST API
* Spring Boot Project Creation
* Spring Initializr
* Maven Project
* Entity Layer
* Repository Layer
* Service Layer
* Controller Layer
* Validation
* Dependency Injection
* CRUD Operations
* Postman Testing
* application.properties
* Spring Data JPA

---

# 🛠 Technologies Used

## Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Tools

* Eclipse IDE
* Spring Initializr
* Postman
* MySQL Workbench

---

# 🚀 Project Creation

## Spring Initializr

Website

```text
https://start.spring.io
```

### Project Configuration

| Property  | Value |
| --------- | ----- |
| Project   | Maven |
| Language  | Java  |
| Packaging | Jar   |

### Dependencies

* Spring Web
* Spring Data JPA
* MySQL Driver
* Validation
* Spring Boot DevTools

---

# 📂 Project Structure

```text
DoctorApp
│
├── CONTROLLER
│   └── DoctorController.java
│
├── ENTITY
│   └── DoctorEntity.java
│
├── REPOSITORY
│   └── DoctorRepository.java
│
├── SERVICE
│   └── DoctorService.java
│
└── DoctorAppApplication.java
```

---

# 🌐 What is REST API?

REST (Representational State Transfer) is an architectural style used for communication between clients and servers using HTTP methods.

### HTTP Methods

| Method | Purpose     |
| ------ | ----------- |
| GET    | Read Data   |
| POST   | Insert Data |
| PUT    | Update Data |
| DELETE | Delete Data |

---

# ▶️ Main Class

The main class starts the Spring Boot application.

```java
@SpringBootApplication
public class DoctorAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            DoctorAppApplication.class,
            args
        );
    }
}
```

---

# 🗂 Entity Layer

Class

```text
DoctorEntity.java
```

### Purpose

Maps Java objects to the database table.

### Annotations Used

* `@Entity`
* `@Table(name = "doctors")`
* `@Id`
* `@GeneratedValue`

---

# ✅ Validation Annotations

### `@NotBlank`

Ensures that the field is not empty.

```java
@NotBlank
private String doctorName;
```

### `@Size(min = 3, max = 50)`

Validates the length of a string.

### `@Min(25)`

Minimum allowed value.

### `@Max(60)`

Maximum allowed value.

### `@Positive`

Ensures the value is greater than zero.

```java
@Positive
private int doctorSalary;
```

---

# 📦 Repository Layer

Repository Interface

```java
@Repository
public interface DoctorRepository
extends JpaRepository<DoctorEntity, Integer> {

}
```

### Purpose

Provides built-in CRUD operations.

### Available Methods

* `save()`
* `findAll()`
* `findById()`
* `deleteById()`
* `count()`
* `existsById()`

---

# ⚙️ Service Layer

Annotation

```java
@Service
```

### Purpose

Contains the business logic.

### Methods

* `createDoctor()`
* `readAllDoctors()`
* `readParticularDoctor()`
* `deleteParticularDoctor()`

---

# 🌐 Controller Layer

Annotation

```java
@RestController
@RequestMapping("/doctor")
```

### Purpose

Handles client requests and exposes REST endpoints.

---

# ➕ POST API

### Endpoint

```http
POST /doctor/create
```

### Annotation

```java
@PostMapping("/create")
```

### Purpose

Inserts doctor details into the database.

### Sample JSON

```json
{
  "doctorName": "Ramu",
  "doctorAge": 31,
  "doctorSpeciality": "Neurology",
  "doctorSalary": 55000
}
```

---

# 📖 GET ALL API

### Endpoint

```http
GET /doctor/all
```

### Annotation

```java
@GetMapping("/all")
```

### Purpose

Returns all doctor records.

---

# 🔍 GET BY ID API

### Endpoint

```http
GET /doctor/{doctorId}
```

Example

```text
GET /doctor/1
```

### Annotation

```java
@GetMapping("/{doctorId}")
```

### Purpose

Returns a specific doctor record.

---

# ❌ DELETE API

### Endpoint

```http
DELETE /doctor/{doctorId}
```

Example

```text
DELETE /doctor/2
```

### Annotation

```java
@DeleteMapping("/{doctorId}")
```

### Purpose

Deletes the specified doctor record.

---

# 💉 Dependency Injection

Annotation

```java
@Autowired
```

### Purpose

Automatically creates and injects required objects.

### Example

```java
@Autowired
private DoctorService doctorService;

@Autowired
private DoctorRepository doctorRepository;
```

---

# ⚙️ application.properties

```properties
spring.application.name=DoctorApp

spring.datasource.url=jdbc:mysql://localhost:3306/doctor_db
spring.datasource.username=root
spring.datasource.password=******

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8081
```

---

# 🧪 Postman Testing

Postman was used to test all REST APIs.

### APIs Tested

* POST
* GET ALL
* GET BY ID
* DELETE

---

# 🔄 Flow of Execution

```text
Postman Request
        │
        ▼
Controller
        │
        ▼
Service
        │
        ▼
Repository
        │
        ▼
MySQL Database
```

---

# 🎯 Learning Outcomes

By completing this task, I learned how to:

* Build REST APIs using Spring Boot.
* Understand HTTP methods (GET, POST, PUT, DELETE).
* Create layered architecture using Controller, Service, Repository, and Entity.
* Validate user input using Bean Validation annotations.
* Perform CRUD operations using Spring Data JPA.
* Configure database connectivity using `application.properties`.
* Test REST APIs using Postman.
* Apply Dependency Injection using `@Autowired`.

---

# 💼 Interview Questions

### 1. What is REST API?

REST API is used for communication between clients and servers using HTTP methods.

### 2. What is `@RestController`?

Creates REST API endpoints.

### 3. What is `@RequestMapping`?

Defines the base URL for a controller.

### 4. What is `@PathVariable`?

Reads values from the URL.

### 5. What is `@RequestBody`?

Converts JSON request data into a Java object.

### 6. What is `JpaRepository`?

Provides built-in CRUD operations.

### 7. What is `@Autowired`?

Performs Dependency Injection.

### 8. What is `@Valid`?

Triggers validation rules before processing data.

### 9. Difference between Controller and Service?

**Controller**

* Handles HTTP requests.

**Service**

* Contains business logic.

### 10. What is Validation?

Validation checks user input before storing it in the database.

---

# 📖 Topics Covered Summary

* Spring Initializr
* Spring Boot
* REST API
* Entity Layer
* Repository Layer
* Service Layer
* Controller Layer
* Validation
* Dependency Injection
* CRUD Operations
* Postman Testing
* Spring Data JPA

---

# 🚀 Day 09 Summary

✅ Learned the fundamentals of **REST APIs** using Spring Boot.

✅ Developed a **Doctor Management System** following a layered architecture.

✅ Implemented CRUD operations using **Spring Data JPA**.

✅ Applied validation using Bean Validation annotations.

✅ Used Dependency Injection with `@Autowired`.

✅ Tested all APIs using **Postman**.

✅ Connected the application to a **MySQL** database and successfully performed database operations.
