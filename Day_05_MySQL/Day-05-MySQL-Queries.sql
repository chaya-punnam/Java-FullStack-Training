-- =========================
-- DAY 05 - MYSQL BASICS
-- =========================

-- Create Databases
CREATE DATABASE employee_db;
CREATE DATABASE student_db;

-- Use Database
USE employee_db;

-- Create Employee Table
CREATE TABLE employees (
    id INT,
    name VARCHAR(15),
    age INT,
    salary INT,
    jobrole VARCHAR(20)
);

-- Insert Records
INSERT INTO employees VALUES (100, "Raju", 35, 40000, "Developer");
INSERT INTO employees VALUES (101, "Ramu", 45, 50000, "Tester");
INSERT INTO employees VALUES (102, "Rani", 25, 70000, "HR");
INSERT INTO employees VALUES (103, "John", 50, 90000, "Developer");
INSERT INTO employees VALUES (104, "Tim", 35, 50000, "Developer");
INSERT INTO employees VALUES (105, "Mary", 45, 20000, "Tester");

-- Display All Records
SELECT * FROM employees;

-- Column Aliases
SELECT id AS employee_id, name AS employee_name
FROM employees;

SELECT id employee_id, name employee_name
FROM employees;

-- Count with Duplicates
SELECT COUNT(age) AS totalAgeCount
FROM employees;

-- Count without Duplicates
SELECT COUNT(DISTINCT age) AS uniqueAgeCount
FROM employees;

-- Constant Value Column
SELECT id, name, 'INDIA' AS country
FROM employees;

-- Salary Greater Than 50000
SELECT name, salary
FROM employees
WHERE salary > 50000;

-- Developers List
SELECT name
FROM employees
WHERE jobrole = "Developer";

-- Employees Age 35
SELECT name, salary, age
FROM employees
WHERE age = 35;

-- LIKE Operator Examples
SELECT name
FROM employees
WHERE name LIKE 'R%';

SELECT name
FROM employees
WHERE name LIKE 'J%';

SELECT name
FROM employees
WHERE name LIKE 'Ram%';

SELECT name
FROM employees
WHERE name LIKE 'Ra_u';

SELECT name
FROM employees
WHERE name LIKE '__u';

SELECT name
FROM employees
WHERE name LIKE 'R_%';

SELECT name
FROM employees
WHERE name LIKE '_%';

-- Highest Salary Employee
SELECT name
FROM employees
ORDER BY salary DESC
LIMIT 1;

-- Lowest Salary Employee
SELECT name, salary
FROM employees
ORDER BY salary ASC
LIMIT 1;

-- 2nd Highest Salary Employee
SELECT name
FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

-- 3rd Lowest Salary Employee
SELECT name, salary
FROM employees
ORDER BY salary ASC
LIMIT 1 OFFSET 2;

SELECT name, salary
FROM employees
ORDER BY salary ASC, name ASC
LIMIT 1 OFFSET 2;

-- =========================
-- GROUP BY & HAVING
-- =========================

CREATE DATABASE order_db;

USE order_db;

CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    restaurant VARCHAR(100),
    food_item VARCHAR(100),
    category VARCHAR(50),
    price INT
);

INSERT INTO Orders (order_id, restaurant, food_item, category, price)
VALUES
(1, 'A1 Bistro', 'Burger', 'Fast Food', 200),
(2, 'A1 Bistro', 'Pizza', 'Fast Food', 400),
(3, 'Spice Hub', 'Biryani', 'Indian', 300),
(4, 'Spice Hub', 'Pasta', 'Italian', 250),
(5, 'Food Court', 'Burger', 'Fast Food', 180),
(6, 'Food Court', 'Pizza', 'Fast Food', 350),
(7, 'Spice Hub', 'Biryani', 'Indian', 320);

-- Total Price by Restaurant
SELECT restaurant, SUM(price) AS total_price
FROM Orders
GROUP BY restaurant;

-- Maximum Order Price by Restaurant
SELECT restaurant, MAX(price) AS max_price
FROM Orders
GROUP BY restaurant
HAVING MAX(price) > 350;