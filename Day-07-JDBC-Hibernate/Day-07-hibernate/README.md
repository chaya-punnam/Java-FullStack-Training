# 📅 Day 07 – Hibernate Framework

## 📌 Overview

On Day 07, I learned the fundamentals of the **Hibernate Framework**, an ORM (Object Relational Mapping) framework that simplifies database operations in Java applications. I also learned how Hibernate maps Java objects to database tables and performs CRUD operations without writing JDBC boilerplate code.

---

# 📚 Topics Covered

* Introduction to Hibernate
* Object Relational Mapping (ORM)
* Maven Project Creation
* Hibernate Dependencies
* Entity Class
* Constructors
* Getters and Setters
* Hibernate Configuration (`hibernate.cfg.xml`)
* Hibernate Dialect
* `hibernate.hbm2ddl.auto`
* Entity Mapping
* Hibernate Workflow
* SessionFactory
* Session
* Transaction
* `persist()` Method
* Hibernate CRUD Basics

---

# 🛠 Technologies Used

## Backend

* Java
* Hibernate Framework
* Maven
* JDBC
* MySQL

## Tools

* Eclipse IDE
* MySQL Workbench
* Maven

---

# 📂 Project Structure

```text
FirstHibernateProject/
│── src/
│   ├── main/java/
│   │   ├── Entity/
│   │   ├── Main/
│   │
│   └── resources/
│       └── hibernate.cfg.xml
│
├── pom.xml
└── README.md
```

---

# ⚙️ Maven Project Creation

## IDE

* Eclipse IDE

## Project Type

* Maven Project

## Archetype

```text
maven-archetype-quickstart
```

---

# 📦 Required Maven Dependencies

* Hibernate Core
* MySQL Connector
* Jakarta Persistence API

Maven automatically downloads all required libraries through **pom.xml**.

---

# 🧩 What is Hibernate?

Hibernate is an **ORM (Object Relational Mapping)** Framework used to simplify database operations in Java applications.

### Without Hibernate

```text
Java → JDBC → Database
```

### With Hibernate

```text
Java Objects → Hibernate → Database
```

### Advantages

* Reduces JDBC boilerplate code
* Maps Java classes to database tables automatically
* Supports CRUD operations
* Database Independent
* Improves developer productivity

---

# 🔄 What is ORM?

ORM stands for **Object Relational Mapping**.

| Java     | Database |
| -------- | -------- |
| Class    | Table    |
| Object   | Row      |
| Variable | Column   |

### Example

#### Java Entity

```java
class BookEntity {

    int bookId;
    String bookTitle;

}
```

#### Database Table

| bookId | bookTitle |
| ------ | --------- |
| 1      | Java      |
| 2      | Python    |

Hibernate automatically maps the Java class to the database table.

---

# 🏗 Entity Class

Entity Class:

```text
BookEntity.java
```

### Annotations Used

* `@Entity`
* `@Table`
* `@Id`

### Example

```java
@Entity
@Table(name="books")
public class BookEntity {

    @Id
    private int bookId;

    private String bookTitle;
    private int bookPrice;
    private String bookAuthor;
}
```

---

# 🔨 Constructors

### Default Constructor

Required by Hibernate.

```java
public BookEntity() {

}
```

### Parameterized Constructor

Used to initialize object values.

---

# 🔑 Getters and Setters

Used to access and modify private variables.

Example:

```java
public int getBookId() {
    return bookId;
}

public void setBookId(int bookId) {
    this.bookId = bookId;
}
```

---

# ⚙️ Hibernate Configuration File

Configuration File:

```text
hibernate.cfg.xml
```

### Contains

* Database URL
* Username
* Password
* Hibernate Dialect
* Table Creation Strategy
* Entity Mapping

Example

```xml
<property name="hibernate.connection.url">
jdbc:mysql://localhost:3306/book_db
</property>

<property name="hibernate.connection.username">
root
</property>

<property name="hibernate.connection.password">
root
</property>
```

---

# 🗄 Hibernate Dialect

Property

```text
hibernate.dialect
```

Example

```text
org.hibernate.dialect.MySQLDialect
```

Purpose:

Specifies which database Hibernate is communicating with.

---

# 🔄 hbm2ddl.auto

Property

```text
hibernate.hbm2ddl.auto
```

Options

* `create`
* `update`
* `create-drop`
* `validate`

Example

```xml
<property name="hibernate.hbm2ddl.auto">
update
</property>
```

---

# 📝 Entity Mapping

Registers the entity class with Hibernate.

Example

```xml
<mapping class="com.abc.demo.FirstHibernateProject.BookEntity"/>
```

---

# 🔄 Hibernate Workflow

```text
Configuration
      │
      ▼
Load hibernate.cfg.xml
      │
      ▼
Build SessionFactory
      │
      ▼
Open Session
      │
      ▼
Begin Transaction
      │
      ▼
Perform CRUD Operation
      │
      ▼
Commit Transaction
```

---

# 🏭 SessionFactory

Creates Session objects.

Example

```java
SessionFactory factory =
config.buildSessionFactory();
```

---

# 🔗 Session

Acts as the connection between the Java application and the database.

Used for:

* Insert
* Update
* Delete
* Retrieve

Example

```java
Session session =
factory.openSession();
```

---

# 💾 Transaction

Ensures data consistency.

Methods

```java
beginTransaction();
commit();
```

Example

```java
Transaction t = session.beginTransaction();

t.commit();
```

---

# 📥 persist() Method

Method

```java
session.persist(object);
```

Purpose

Used to insert Java object data into the database.

Example

```java
session.persist(book1);
session.persist(book2);
```

---

# 💻 Example

```java
BookEntity b1 = new BookEntity();

b1.setBookId(12);
b1.setBookTitle("Java Programming");
b1.setBookPrice(400);

session.persist(b1);
```

---

# 📊 Output

## Database

```text
book_db
```

## Table

```text
books
```

## Records Inserted

| Book ID | Book Title         | Price |
| ------- | ------------------ | ----- |
| 12      | Java Programming   | 400   |
| 13      | Python Programming | 300   |

---

# 🎯 Learning Outcomes

By completing this task, I learned how to:

* Understand Object Relational Mapping (ORM).
* Configure Hibernate using `hibernate.cfg.xml`.
* Create Entity classes using annotations.
* Use SessionFactory and Session.
* Perform database operations using Hibernate.
* Manage Transactions.
* Insert records using `persist()`.
* Connect Java applications with MySQL using Hibernate.

---



### 1. What is Hibernate?

Hibernate is an ORM framework used to simplify database operations in Java.

### 2. What is ORM?

Object Relational Mapping.

### 3. Difference between JDBC and Hibernate?

* JDBC → Manual SQL Queries
* Hibernate → Object-Oriented Database Operations

### 4. What is SessionFactory?

Creates Session objects.

### 5. What is Session?

Used to perform CRUD operations.

### 6. What is `@Entity`?

Marks a Java class as a Hibernate Entity.

### 7. What is `@Table`?

Maps the Entity class to a database table.

### 8. What is `@Id`?

Represents the Primary Key.

### 9. Why is a default constructor required?

Hibernate uses it internally to create objects.

### 10. What does `session.persist()` do?

It inserts object data into the database.

---

# 🚀 Day 07 Summary

✅ Learned the fundamentals of the Hibernate Framework.

✅ Understood Object Relational Mapping (ORM).

✅ Created a Maven project with Hibernate dependencies.

✅ Configured Hibernate using `hibernate.cfg.xml`.

✅ Created Entity classes using Hibernate annotations.

✅ Learned SessionFactory, Session, Transaction, and `persist()`.

✅ Successfully inserted records into a MySQL database using Hibernate.
