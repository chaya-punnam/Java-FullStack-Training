=========================================
DAY 07 - HIBERNATE FRAMEWORK
============================

1. What is Hibernate?

---

Hibernate is an ORM (Object Relational Mapping) Framework used to simplify database operations in Java applications.

Without Hibernate:
Java --> JDBC --> Database

With Hibernate:
Java Objects --> Hibernate --> Database

## Advantages:

1. Reduces JDBC boilerplate code.
2. Automatically maps Java classes to database tables.
3. Supports CRUD operations.
4. Database independent.
5. Improves productivity.

=========================================
2. What is ORM?
===============

ORM = Object Relational Mapping

Object ---> Table
Class ---> Table
Object ---> Row
Variable ---> Column

Example:

## Java Class:

class BookEntity {
int bookId;
String bookTitle;
}

## Database Table:

## books

## bookId | bookTitle

1      | Java
2      | Python

Hibernate automatically maps the class to the table.

=========================================
3. Maven Project Creation
=========================

## IDE Used:

Eclipse IDE

## Project Type:

Maven Project

## Archetype Used:

maven-archetype-quickstart

## Benefits of Maven:

1. Dependency Management
2. Build Automation
3. Easy Project Structure
4. Download Required Libraries Automatically

## Standard Maven Structure:

src/main/java
src/test/java
pom.xml

=========================================
4. Hibernate Dependencies
=========================

Hibernate libraries are added through Maven dependencies in pom.xml.

## Required Dependencies:

1. Hibernate Core
2. MySQL Connector
3. Jakarta Persistence API

Maven automatically downloads all required JAR files.

=========================================
5. Entity Class
===============

## Entity Class:

BookEntity.java

## Purpose:

Represents a database table.

## Annotations Used:

## @Entity

Marks the class as a Hibernate Entity.

## @Table(name="books")

Maps the class to the "books" table.

## @Id

Specifies the Primary Key column.

Example:

@Entity
@Table(name="books")
public class BookEntity {

```
@Id
private int bookId;

private String bookTitle;
private int bookPrice;
private String bookAuthor;
```

}

=========================================
6. Constructors
===============

## Parameterized Constructor:

Used to initialize values.

## Default Constructor:

Required by Hibernate.

Example:

public BookEntity() {
}

=========================================
7. Getters and Setters
======================

## Purpose:

Used to access and modify private variables.

Example:

public int getBookId() {
return bookId;
}

public void setBookId(int bookId) {
this.bookId = bookId;
}

=========================================
8. Hibernate Configuration File
===============================

## File Name:

hibernate.cfg.xml

## Purpose:

Used to configure database connection.

## Contains:

1. Database URL
2. Username
3. Password
4. Hibernate Dialect
5. Table Creation Strategy
6. Entity Mapping

Example:

<property name="hibernate.connection.url">
jdbc:mysql://localhost:3306/book_db
</property>

<property name="hibernate.connection.username">
root
</property>

<property name="hibernate.connection.password">
root
</property>

=========================================
9. Hibernate Dialect
====================

Property:

hibernate.dialect

## Purpose:

Tells Hibernate which database is being used.

Example:

org.hibernate.dialect.MySQLDialect

=========================================
10. hbm2ddl.auto
================

Property:

hibernate.hbm2ddl.auto

## Options:

## create

Drops old table and creates new table.

## update

Updates existing table without deleting data.

## create-drop

Creates table and deletes after execution.

## validate

Checks schema compatibility.

Example:

<property name="hibernate.hbm2ddl.auto">
update
</property>

=========================================
11. Mapping Entity
==================

## Purpose:

Registers entity class with Hibernate.

Example:

<mapping class=
"com.abc.demo.FirstHibernateProject.BookEntity"/>

=========================================
12. Hibernate Workflow
======================

## Step 1:

Create Configuration Object

Configuration config =
new Configuration();

## Step 2:

Load Configuration File

config.configure("hibernate.cfg.xml");

## Step 3:

Build SessionFactory

SessionFactory factory =
config.buildSessionFactory();

## Step 4:

Open Session

Session session =
factory.openSession();

## Step 5:

Begin Transaction

Transaction t =
session.beginTransaction();

## Step 6:

Perform Operation

session.persist(object);

## Step 7:

Commit Transaction

t.commit();

=========================================
13. SessionFactory
==================

SessionFactory is responsible for creating Session objects.

One SessionFactory is generally created per application.

Example:

SessionFactory factory =
config.buildSessionFactory();

=========================================
14. Session
===========

Session acts as a connection between Java application and database.

## Used for:

1. Insert
2. Update
3. Delete
4. Retrieve

Example:

Session session =
factory.openSession();

=========================================
15. Transaction
===============

Transaction ensures data consistency.

Methods:

beginTransaction()
commit()

Example:

Transaction t =
session.beginTransaction();

t.commit();

=========================================
16. Persist Method
==================

Method:

session.persist(object);

## Purpose:

Inserts object data into database table.

Example:

session.persist(b1);
session.persist(b2);

=========================================
17. Example Execution
=====================

BookEntity b1 = new BookEntity();

b1.setBookId(12);
b1.setBookTitle("Java Programming");
b1.setBookPrice(400);

session.persist(b1);

## Result:

A new record is inserted into the books table.

=========================================
18. Output
==========

## Database Created:

book_db

## Table Created:

books

## Records Inserted:

Book ID : 12
Book Title : Java Programming
Book Price : 400

Book ID : 13
Book Title : Python Programming
Book Price : 300

=========================================
19. Interview Questions
=======================

Q1. What is Hibernate?
A. Hibernate is an ORM Framework used to simplify database operations.

Q2. What is ORM?
A. Object Relational Mapping.

Q3. Difference between JDBC and Hibernate?
A.
JDBC -> Manual SQL Queries.
Hibernate -> Object based operations.

Q4. What is SessionFactory?
A. Factory used to create Session objects.

Q5. What is Session?
A. Used to perform CRUD operations.

Q6. What is @Entity?
A. Marks a class as Hibernate Entity.

Q7. What is @Table?
A. Maps class to database table.

Q8. What is @Id?
A. Represents Primary Key.

Q9. Why is default constructor required?
A. Hibernate uses it internally to create objects.

Q10. What does session.persist() do?
A. Inserts object data into database.

=========================================
END OF DAY 07
=============
