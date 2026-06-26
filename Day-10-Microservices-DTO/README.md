# 📅 Day 10 – Spring Boot Microservices, DTO, Synchronous & Asynchronous Communication

## 📌 Overview

On Day 10, I learned the fundamentals of **Spring Boot Microservices**, **Data Transfer Objects (DTOs)**, and communication between microservices using **REST APIs**. I also explored the concepts of **Synchronous** and **Asynchronous Communication**, along with messaging systems like **Apache Kafka** and **RabbitMQ**. Additionally, I implemented communication between the **Doctor Service** and **Hospital Service** using `RestTemplate`.

---

# 📚 Topics Covered

* Data Transfer Object (DTO)
* Spring Boot Microservices
* REST API Communication
* RestTemplate
* Synchronous Communication
* Asynchronous Communication
* Apache Kafka
* RabbitMQ
* Doctor Service
* Hospital Service
* DTO Mapping

---

# 🛠 Technologies Used

## Backend

* Java
* Spring Boot
* Spring Data JPA
* REST API
* Hibernate
* MySQL

## Microservices

* Doctor Service
* Hospital Service
* RestTemplate

## Messaging Technologies

* Apache Kafka
* RabbitMQ

## Tools

* Eclipse IDE
* Postman
* MySQL Workbench
* Maven

---

# 📦 What is a DTO?

DTO stands for **Data Transfer Object**.

A DTO is a simple Java class used to transfer data between different layers or different microservices without exposing the complete Entity.

---

# 🎯 Why Do We Use DTO?

Without DTO

```text
DoctorEntity → Client
```

All entity fields are exposed.

With DTO

```text
DoctorEntity → DoctorDTO → Client
```

Only the required fields are sent.

### Example

### DoctorEntity

* doctorId
* doctorName
* doctorAge
* doctorSalary
* doctorSpeciality
* hospitalId

### DoctorDTO

* doctorId
* doctorName
* doctorAge
* doctorSpeciality
* hospitalId
* hospitalName
* hospitalLocation

---

# ✅ Advantages of DTO

* Hides unnecessary fields
* Improves API security
* Reduces response size
* Simplifies communication between microservices
* Improves API design

---

# 📝 DoctorDTO Example

```java
public class DoctorDTO {

    private Integer doctorId;
    private String doctorName;
    private int doctorAge;
    private String doctorSpeciality;

    private Integer hospitalId;
    private String hospitalName;
    private String hospitalLocation;
}
```

---

# 📤 Sample Response

```json
{
  "doctorId": 1,
  "doctorName": "Ramu",
  "doctorAge": 31,
  "doctorSpeciality": "Neurology",
  "hospitalId": 1,
  "hospitalName": "Apollo Hospital",
  "hospitalLocation": "Hyderabad"
}
```

---

# 🌐 What is a Microservice?

A **Microservice** is a small, independent application responsible for a specific business functionality.

## Doctor Service

**Port:** `8082`

Responsibilities

* Create Doctor
* Read Doctor
* Delete Doctor

## Hospital Service

**Port:** `8081`

Responsibilities

* Create Hospital
* Read Hospital
* Delete Hospital

Both applications run independently and communicate through REST APIs.

---

# 🔄 Communication Between Microservices

The Doctor Service stores only the `hospitalId`.

To retrieve complete hospital information, the Doctor Service sends a request to the Hospital Service.

### Using RestTemplate

```java
RestTemplate template = new RestTemplate();

HospitalDTO hospitalDetail =
template.getForObject(
"http://localhost:8081/hospital/" + hospitalId,
HospitalDTO.class);
```

The Doctor Service combines Doctor data and Hospital data using `DoctorDTO`.

---

# 🔄 Synchronous Communication

In synchronous communication, the sender waits for the receiver to respond before continuing execution.

### Workflow

```text
Doctor Service
      │
      ▼
Hospital Service
      │
      ▼
Waits for Response
      │
      ▼
Continues Execution
```

### Example

```java
RestTemplate template = new RestTemplate();

HospitalDTO hospital =
template.getForObject(
"http://localhost:8081/hospital/1",
HospitalDTO.class);
```

### Examples

* REST API
* SOAP Web Services
* OpenFeign Client

### Advantages

* Easy to understand
* Easy to implement
* Immediate response

### Disadvantages

* Tight coupling
* Slower if another service is unavailable
* Service dependency

---

# ⚡ Asynchronous Communication

In asynchronous communication, the sender does not wait for the receiver's response.

### Workflow

```text
Doctor Service
      │
      ▼
Sends Message
      │
      ▼
Continues Execution
      │
      ▼
Hospital Service Processes Later
```

### Advantages

* High performance
* Loose coupling
* Better scalability
* Faster execution

### Disadvantages

* More complex implementation
* Difficult debugging

---

# 📨 Apache Kafka

Apache Kafka is a distributed event streaming platform used for asynchronous communication.

### Components

* Producer
* Topic
* Consumer

### Workflow

```text
Producer
    │
    ▼
 Topic
    │
    ▼
Consumer
```

### Example

Doctor Service publishes:

```text
New Doctor Created
```

Kafka stores the message inside a Topic.

Hospital Service consumes the message later.

### Benefits

* High Performance
* Fault Tolerance
* Real-Time Processing
* Highly Scalable

---

# 📨 RabbitMQ

RabbitMQ is a Message Broker used for asynchronous communication.

### Components

* Producer
* Queue
* Consumer

### Workflow

```text
Producer
    │
    ▼
 Queue
    │
    ▼
Consumer
```

Messages remain in the queue until consumers process them.

---

# ⚖️ Kafka vs RabbitMQ

| Apache Kafka                 | RabbitMQ                  |
| ---------------------------- | ------------------------- |
| Topic Based                  | Queue Based               |
| Event Streaming              | Message Processing        |
| High Throughput              | Reliable Message Delivery |
| Best for Real-Time Streaming | Best for Task Processing  |

---

# 📂 Project Structure

## HospitalApp

```text
HospitalApp
│
├── CONTROLLER
│   └── HospitalController
│
├── SERVICE
│   └── HospitalService
│
├── REPOSITORY
│   └── HospitalRepository
│
├── ENTITY
│   └── HospitalEntity
│
├── DTO
│   └── HospitalDTO
│
└── application.properties
```

## DoctorApp

```text
DoctorApp
│
├── CONTROLLER
├── SERVICE
├── REPOSITORY
├── ENTITY
├── DTO
└── application.properties
```

---

# 🎯 Learning Outcomes

By completing this task, I learned how to:

* Understand the purpose of DTOs.
* Hide sensitive entity data using DTOs.
* Build independent Spring Boot Microservices.
* Communicate between microservices using REST APIs.
* Use `RestTemplate` for synchronous communication.
* Understand synchronous and asynchronous communication models.
* Learn the basics of Apache Kafka and RabbitMQ.
* Design scalable microservice-based applications.

---
