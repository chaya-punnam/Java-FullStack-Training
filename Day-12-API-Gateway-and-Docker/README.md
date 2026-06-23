# Day 12 – API Gateway and Docker Integration

## Overview

This session focused on implementing an API Gateway in a Spring Boot Microservices Architecture and introducing Docker containerization.

The API Gateway was configured as a centralized entry point for microservices, integrated with Eureka Service Discovery, and tested using Postman.

Additionally, Docker was used to pull and run a MySQL container, enabling database deployment through containerization.

---

## Objectives

- Understand the purpose of API Gateway.
- Create an API Gateway project using Spring Initializr.
- Configure routing between microservices.
- Register API Gateway with Eureka Server.
- Test routing through Postman.
- Learn Docker fundamentals.
- Pull Docker images from Docker Hub.
- Create and run MySQL containers.
- Access MySQL running inside Docker.

---

# API Gateway

## What is API Gateway?

API Gateway acts as a single entry point for all client requests in a Microservices Architecture.

Instead of communicating directly with multiple services, clients communicate only with the API Gateway.

---

## Architecture

```text
                Client
                   |
                   |
                   v
           API Gateway (9090)
             /           \
            /             \
           v               v
 DoctorApp(8082)    HospitalApp(8081)
```

---

## Benefits of API Gateway

- Centralized Routing
- Single Entry Point
- Improved Security
- Simplified Client Communication
- Load Balancing Support
- Monitoring and Logging
- Better Scalability

---

# Project Creation Using Spring Initializr

## Configuration

| Property | Value |
|-----------|---------|
| Project | Maven |
| Language | Java |
| Spring Boot | 3.5.15 |
| Packaging | Jar |
| Java | 17 |

---

## Dependencies Added

### Gateway

Provides API routing functionality.

### Eureka Discovery Client

Registers API Gateway with Eureka Server.

### Spring Boot Actuator

Used for monitoring and health checks.

---

# Project Structure

```text
APIGateWay
│
├── src/main/java
│   └── ApiGateWayApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── src/test/java
│
├── pom.xml
│
└── target
```

---

# Docker Commands Practiced

## Pull MySQL Image

```bash
docker pull mysql:oraclelinux9
```

## Run MySQL Container

```bash
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin -p 9000:3306 mysql:oraclelinux9
```

## Enter Running Container

```bash
docker exec -it mysql-container bash
```

## Login to MySQL

```bash
mysql -u root -p
```

Password:

```text
admin
```

---

# Outcome

Successfully created and configured an API Gateway for Spring Boot Microservices.

Integrated the Gateway with Eureka Service Discovery and verified routing through Postman.

Additionally, Docker was introduced for containerization, and a MySQL database container was successfully deployed, accessed, and managed using Docker commands.
