# 📅 Day 14 – React JS Integration with Spring Boot

## 📌 Overview

On Day 14, I learned the fundamentals of **React JS** and successfully integrated a React frontend with a **Spring Boot REST API**. I developed a user input form in React that collects doctor details and sends the data to the Spring Boot backend using **Axios**. The backend receives the JSON data and stores it in a **MySQL** database.

---

# 📚 Topics Covered

* Introduction to React JS
* Creating a React Project using Vite
* JSX (JavaScript XML)
* Functional Components
* React Hooks (`useState`)
* Event Handling in React
* Form Handling
* Controlled Components
* Axios for HTTP Requests
* REST API Integration
* Cross-Origin Resource Sharing (CORS)
* Connecting React with Spring Boot
* Sending JSON Data
* Inserting Data into MySQL Database

---

# 🛠 Technologies Used

## Frontend

* React JS
* Vite
* JavaScript (ES6)
* HTML
* CSS
* Axios

## Backend

* Spring Boot
* Spring Data JPA
* REST API
* Hibernate
* MySQL

## Tools

* Visual Studio Code
* Eclipse IDE
* Postman
* MySQL Workbench
* Git & GitHub

---

# ⚙️ React Project Setup Commands

## Create React Project

```bash
npm create vite@latest doctor
```

### Select Framework

```text
React
```

### Select Variant

```text
JavaScript
```

## Navigate to Project

```bash
cd doctor
```

## Install Dependencies

```bash
npm install
```

## Install Axios

```bash
npm install axios
```

## Start React Application

```bash
npm run dev
```

React Application runs on:

```text
http://localhost:5173
```

---

# ▶️ Spring Boot Application

Run the Spring Boot application from Eclipse.

Server Port:

```properties
server.port=8082
```

REST API Endpoint:

```text
http://localhost:8082/doctor/create
```

---

# 📂 Project Workflow

```text
React Form
      │
      ▼
Axios POST Request
      │
      ▼
Spring Boot REST Controller
      │
      ▼
Service Layer
      │
      ▼
Repository Layer
      │
      ▼
MySQL Database
```

---

# 📝 Features Implemented

* Created a React application using Vite.
* Designed a Doctor Registration Form.
* Used React `useState()` Hook for managing form data.
* Implemented Controlled Components.
* Used Axios to send HTTP POST requests.
* Connected React frontend with Spring Boot REST API.
* Configured CORS using `@CrossOrigin`.
* Sent JSON data from React to Spring Boot.
* Stored doctor details into MySQL database.
* Displayed success message after successful data insertion.

---

# 📄 Doctor Form Fields

* Doctor Name
* Doctor Specialization
* Doctor Age
* Doctor Salary
* Hospital ID

---

# 📤 Sample JSON Sent to Backend

```json
{
  "doctorName": "Alice",
  "doctorSpeciality": "Dentist",
  "doctorAge": 30,
  "doctorSalary": 60000,
  "hospitalId": 4
}
```

---

# 🌐 API Used

## Create Doctor

```http
POST /doctor/create
```

Example URL

```text
http://localhost:8082/doctor/create
```

---

# 🔧 React Concepts Practiced

* React Functional Components
* JSX
* useState Hook
* Event Handling
* Form Handling
* Controlled Components
* Form Submission
* Axios POST Request
* Async / Await
* JSON Handling
* API Integration

---

# 🔧 Spring Boot Concepts Practiced

* REST Controller
* `@PostMapping`
* `@RequestBody`
* `@Valid`
* `@CrossOrigin`
* Service Layer
* Repository Layer
* Spring Data JPA
* Entity Mapping
* Validation
* MySQL Integration

---

# 📷 Project Output

## React Application

* Doctor Registration Form
* User-friendly data entry form

## Successful API Response

```text
Data Successfully Inserted!
```

## Database

Doctor details are successfully inserted into the MySQL database through the Spring Boot REST API.

---

# 🎯 Learning Outcomes

By completing this task, I learned how to:

* Build React forms using Functional Components.
* Manage application state using the `useState()` Hook.
* Handle user input through Controlled Components.
* Send HTTP requests using Axios.
* Connect a React frontend with Spring Boot REST APIs.
* Exchange JSON data between frontend and backend.
* Configure Cross-Origin Resource Sharing (CORS).
* Store user data into a MySQL database.
* Understand the complete frontend-to-backend communication workflow.

---


