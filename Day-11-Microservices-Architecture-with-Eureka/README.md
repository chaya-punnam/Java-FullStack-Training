# Day 11 – Spring Boot Microservices, Service Discovery and Application Deployment

## Overview

This session focused on implementing a Microservices Architecture using Spring Boot and Netflix Eureka. Multiple independent services were developed, registered with a Eureka Server, and deployed as executable JAR files. The session also covered service communication mechanisms, service discovery, load balancing concepts, and an introduction to messaging platforms such as Apache Kafka and RabbitMQ.

---

## Objectives

* Understand Microservices Architecture.
* Understand Spring IoC Container and Bean Management.
* Implement Dependency Injection using Spring Beans.
* Configure and deploy a Eureka Server.
* Register microservices as Eureka Clients.
* Implement inter-service communication using RestTemplate and WebClient.
* Explore synchronous and asynchronous communication models.
* Build executable JAR files using Maven.
* Deploy multiple instances of services using different ports.
* Observe service registration and discovery through the Eureka Dashboard.

---

## Microservices Architecture

Three Spring Boot applications were used during the implementation:

### NetflixEurekaServerProject

Acts as the Service Registry responsible for maintaining information about all active services.

### HospitalApp

Provides hospital-related operations and registers itself with Eureka Server.

### DoctorApp

Provides doctor-related operations and communicates with HospitalApp through service discovery.

---
## Spring IoC Container and Beans

Spring Framework manages application objects using the Inversion of Control (IoC) Container. The IoC Container is responsible for creating, configuring, storing, and managing the lifecycle of objects known as Spring Beans.

### Spring Beans

A Bean is an object that is created and managed by the Spring IoC Container. Beans can be defined using annotations such as:

* @Component
* @Service
* @Repository
* @Controller
* @RestController
* @Bean

Examples from the implementation include:

```java
@Bean
public RestTemplate template() {
    return new RestTemplate();
}

@Bean
public WebClient webClient() {
    return WebClient.builder().build();
}
```

In this case, RestTemplate and WebClient objects are registered as Spring Beans and stored inside the IoC Container.

### Dependency Injection

Spring provides objects automatically using Dependency Injection. Instead of manually creating objects using the `new` keyword, dependencies can be injected using the `@Autowired` annotation.

Example:

```java
@Autowired
private RestTemplate template;

@Autowired
private WebClient webClient;
```

The Spring IoC Container automatically provides the required Bean instances whenever they are needed.

### Benefits of IoC and Beans

* Reduces object creation complexity.
* Promotes loose coupling between components.
* Improves maintainability and scalability.
* Enables centralized object management.
* Supports Dependency Injection throughout the application.

The concepts of IoC Container and Beans form the foundation of Spring Framework and are extensively used in Spring Boot applications and Microservices architectures.

---
## Synchronous Communication

Synchronous communication requires the client application to wait until a response is received from the target service.

### Characteristics

* Request-response model.
* Immediate feedback.
* Tight coupling between services.
* Increased dependency on service availability.

### Technologies Studied

* REST API
* RestTemplate
* WebClient (Blocking Mode)
* OpenFeign

### Example

DoctorApp sends a request to HospitalApp and waits until the hospital details are returned.

---

## Asynchronous Communication

Asynchronous communication allows a service to continue execution after sending a request without waiting for an immediate response.

### Characteristics

* Loose coupling.
* Better scalability.
* Improved fault tolerance.
* Suitable for distributed systems.

### Technologies Studied

* Apache Kafka
* RabbitMQ

---

## Apache Kafka

Apache Kafka is a distributed event-streaming platform used for handling large volumes of real-time data.

### Core Components

* Producer
* Topic
* Broker
* Consumer

### Applications

* Event-driven systems
* Activity tracking
* Real-time analytics
* Log aggregation

---

## RabbitMQ

RabbitMQ is a message broker that enables communication between distributed applications through message queues.

### Core Components

* Producer
* Exchange
* Queue
* Consumer

### Applications

* Background processing
* Email services
* Task scheduling
* Payment processing systems

---

## Eureka Service Discovery

Netflix Eureka provides a centralized service registry where microservices register themselves and discover other services dynamically.

### Benefits

* Eliminates hardcoded service URLs.
* Enables dynamic service discovery.
* Supports load balancing.
* Improves maintainability.

### Configuration

Each microservice was configured with:

eureka.client.service-url.defaultZone=http://localhost:8761/eureka

This property allows services to locate and register themselves with the Eureka Server.

---

## Eureka Server Configuration

A dedicated Eureka Server project was created and configured to run on port 8761.

### Main Components

* @EnableEurekaServer
* Spring Cloud Netflix Eureka Server Dependency

### Result

The Eureka Dashboard displayed all registered service instances successfully.

---

## Eureka Client Configuration

DoctorApp and HospitalApp were configured as Eureka Clients.

### Annotations Used

* @EnableDiscoveryClient

### Registration Process

Upon startup, both applications automatically registered themselves with the Eureka Server and became discoverable by other services.

---

## RestTemplate

RestTemplate is a synchronous HTTP client used to invoke REST APIs.

### Implementation

A RestTemplate Bean was configured and used to retrieve hospital information from HospitalApp.

### Load Balanced RestTemplate

The Bean was enhanced using:

@LoadBalanced

This allowed service names registered in Eureka to be used instead of fixed host and port values.

---

## WebClient

WebClient is a modern, reactive HTTP client introduced as part of Spring WebFlux.

### Features

* Non-blocking architecture.
* Reactive programming support.
* Improved scalability.

### Implementation

WebClient was used to retrieve Hospital information through service-to-service communication.

---

## Maven Build Lifecycle

The Maven build process was executed using:

mvn clean package

### Activities Performed

1. Removal of previous build artifacts.
2. Compilation of source code.
3. Execution of unit tests.
4. Packaging of the application.
5. Generation of executable JAR files.

---

## JAR File Deployment

Executable JAR files were generated for both HospitalApp and DoctorApp.

### Generated Artifacts

* HospitalApp-0.0.1-SNAPSHOT.jar
* DoctorApp-0.0.1-SNAPSHOT.jar

---

## Running Multiple Instances

Additional service instances were launched using custom port values.

### HospitalApp

java -jar HospitalApp-0.0.1-SNAPSHOT.jar --server.port=8084

### DoctorApp

java -jar DoctorApp-0.0.1-SNAPSHOT.jar --server.port=8083

This demonstrated horizontal scaling by running multiple instances of the same microservice.

---

## Eureka Dashboard Verification

The Eureka Dashboard displayed:

### DoctorApp

* Instance 1 : Port 8082
* Instance 2 : Port 8083

### HospitalApp

* Instance 1 : Port 8081
* Instance 2 : Port 8084

The status of all instances was shown as UP, confirming successful registration and availability.

---

## Screenshots

### Screenshot 1

Spring Initializr project configuration and dependency selection.

### Screenshot 2

Maven build execution using `mvn clean package`.

### Screenshot 3

DoctorApp deployment using executable JAR on Port 8083.

### Screenshot 4

HospitalApp deployment using executable JAR on Port 8084.

### Screenshot 5

Eureka Dashboard displaying multiple active instances of DoctorApp and HospitalApp.

---

## Outcome

A complete Microservices environment was successfully configured using Spring Boot and Netflix Eureka. Service discovery, load balancing, JAR packaging, deployment, and scaling through multiple instances were implemented and verified through the Eureka Dashboard.
