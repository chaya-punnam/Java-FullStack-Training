Day 12 – API Gateway and Docker Integration
Overview

This session focused on implementing an API Gateway in a Spring Boot Microservices Architecture and introducing Docker containerization. The API Gateway was configured as a centralized entry point for microservices, integrated with Eureka Service Discovery, and tested using Postman. Additionally, Docker was used to pull and run a MySQL container, enabling database deployment through containerization.

Objectives
Understand the purpose of API Gateway.
Create an API Gateway project using Spring Initializr.
Configure routing between microservices.
Register API Gateway with Eureka Server.
Test routing through Postman.
Learn Docker fundamentals.
Pull Docker images from Docker Hub.
Create and run MySQL containers.
Access MySQL running inside Docker.
API Gateway
What is API Gateway?

API Gateway acts as a single entry point for all client requests in a Microservices Architecture.

Instead of communicating directly with multiple services, clients communicate only with the API Gateway.

Architecture
                Client
                   |
                   |
                   v
           API Gateway (9090)
             /           \
            /             \
           v               v
 DoctorApp(8082)    HospitalApp(8081)
Benefits of API Gateway
Centralized Routing
Single Entry Point
Improved Security
Simplified Client Communication
Load Balancing Support
Monitoring and Logging
Better Scalability
Project Creation Using Spring Initializr

The API Gateway project was generated from Spring Initializr.

Configuration
Property	Value
Project	Maven
Language	Java
Spring Boot	3.5.15
Packaging	Jar
Java	17
Dependencies Added
Gateway

Provides API routing functionality.

Gateway
Eureka Discovery Client

Registers API Gateway with Eureka Server.

Eureka Discovery Client
Spring Boot Actuator

Used for monitoring and health checks.

Spring Boot Actuator
Project Structure

The generated API Gateway project contains:

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
Main Components
ApiGateWayApplication.java

Application entry point.

@SpringBootApplication
public class ApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }
}
application.properties

Contains routing and Eureka configurations.

API Gateway Configuration
spring.application.name=APIGateWay

server.port=9090

eureka.client.service-url.defaultZone=http://localhost:8761/eureka

# Doctor Service Route
spring.cloud.gateway.routes[0].id=doctor-microservice
spring.cloud.gateway.routes[0].uri=http://localhost:8082
spring.cloud.gateway.routes[0].predicates[0]=Path=/doctor/**

# Hospital Service Route
spring.cloud.gateway.routes[1].id=hospital-microservice
spring.cloud.gateway.routes[1].uri=http://localhost:8081
spring.cloud.gateway.routes[1].predicates[0]=Path=/hospital/**
Eureka Registration

API Gateway was registered as a Eureka Client.

After starting:

Eureka Server
DoctorApp
HospitalApp
API Gateway

The Eureka Dashboard displayed:

APIGATEWAY
DOCTORAPP
HOSPITALAPP

as active services.

Postman Testing
Direct Access

Doctor Service

http://localhost:8082/doctor/1

Hospital Service

http://localhost:8081/hospital/1
Through API Gateway

Doctor Service

http://localhost:9090/doctor/1

Hospital Service

http://localhost:9090/hospital/1

The requests are forwarded through the Gateway.

Docker
What is Docker?

Docker is a containerization platform used to package and run applications in isolated environments called containers.

Benefits of Docker
Platform Independence
Easy Deployment
Lightweight Containers
Faster Development
Consistent Environment
Docker Commands Practiced
Pull MySQL Image
docker pull mysql:oraclelinux9

Downloads the MySQL image from Docker Hub.

Run MySQL Container
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin -p 9000:3306 mysql:oraclelinux9
Explanation
Option	Description
--name mysql-container	Container Name
MYSQL_ROOT_PASSWORD=admin	Root Password
-p 9000:3306	Port Mapping
mysql:oraclelinux9	Docker Image
Enter Running Container
docker exec -it mysql-container bash
Explanation
docker exec

Executes commands inside a running container.

-it

Interactive terminal mode.

bash

Starts Linux shell inside container.

Login to MySQL
mysql -u root -p

Password:

admin
Docker Architecture
Docker Client
      |
      v
Docker Engine
      |
      v
Docker Container
      |
      v
MySQL Database
Concepts Learned
Microservices

Independent deployable services.

API Gateway

Centralized entry point for all requests.

Eureka Discovery

Service registration and discovery.

Routing

Forwarding requests to target microservices.

Docker

Containerization platform.

Docker Image

Blueprint for creating containers.

Docker Container

Running instance of an image.

Port Mapping
Host Port 9000
        |
        v
Container Port 3306
Outcome

Successfully created and configured an API Gateway for Spring Boot Microservices. Integrated the Gateway with Eureka Service Discovery and verified routing through Postman. Additionally, Docker was introduced for containerization, and a MySQL database container was successfully deployed, accessed, and managed using Docker commands.