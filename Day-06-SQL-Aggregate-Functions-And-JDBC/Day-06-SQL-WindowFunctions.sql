-- ==========================================
-- DAY 06 - CASE STATEMENT & WINDOW FUNCTIONS
-- ==========================================

-- ==========================================
-- CASE STATEMENT EXAMPLE
-- ==========================================

CREATE DATABASE school_db;
USE school_db;

CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50),
    marks INT
);

INSERT INTO Student (student_id, student_name, marks) VALUES
(1, 'Sunil', 95),
(2, 'Ravi', 78),
(3, 'Priya', 65),
(4, 'John', 45),
(5, 'Meera', 88),
(6, 'Martin', 20);

-- Assign Grades Using CASE Statement

SELECT student_name,
       marks,
       CASE
           WHEN marks > 85 THEN 'A'
           WHEN marks > 65 THEN 'B'
           WHEN marks > 35 THEN 'C'
           ELSE 'F'
       END AS grade
FROM Student;


-- ==========================================
-- WINDOW FUNCTIONS
-- ==========================================

CREATE DATABASE company_db;
USE company_db;

CREATE TABLE employee_sales (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept VARCHAR(20),
    salary DECIMAL(10,2),
    sales INT,
    month VARCHAR(10)
);

INSERT INTO employee_sales
(emp_id, emp_name, dept, salary, sales, month)
VALUES
(1, 'Rahul Sharma', 'IT', 5000, 10, 'Jan'),
(2, 'Priya Verma', 'IT', 6000, 20, 'Jan'),
(3, 'Amit Kumar', 'HR', 4000, 15, 'Jan'),
(4, 'Sneha Reddy', 'HR', 4500, 25, 'Jan'),
(5, 'Vikram Singh', 'IT', 7000, 30, 'Feb'),
(6, 'Neha Patel', 'HR', 4200, 18, 'Feb');

SELECT * FROM employee_sales;

-- ==========================================
-- AGGREGATE FUNCTION
-- ==========================================

SELECT dept,SUM(salary) AS totalSalary
FROM employee_sales
GROUP BY dept;

-- ==========================================
-- ROW_NUMBER()
-- ==========================================

SELECT dept,
       salary,
       ROW_NUMBER() OVER
       (PARTITION BY dept ORDER BY salary DESC)
       AS ranking
FROM employee_sales;

-- ==========================================
-- RANK()
-- ==========================================

SELECT dept,
       salary,
       RANK() OVER
       (ORDER BY salary DESC)
       AS ranking
FROM employee_sales;

-- ==========================================
-- ROW_NUMBER()
-- ==========================================

SELECT dept,
       salary,
       ROW_NUMBER() OVER
       (ORDER BY salary DESC)
       AS ranking
FROM employee_sales;

-- ==========================================
-- DENSE_RANK()
-- ==========================================

SELECT dept,
       salary,
       DENSE_RANK() OVER
       (ORDER BY salary DESC)
       AS ranking
FROM employee_sales;

-- ==========================================
-- MAX() OVER()
-- ==========================================

SELECT dept,
       salary,
       MAX(salary)
       OVER (PARTITION BY dept)
       AS highestSalary
FROM employee_sales;

-- ==========================================
-- LAG()
-- ==========================================

SELECT emp_name,
       salary,
       LAG(salary)
       OVER (ORDER BY salary)
       AS previous_salary
FROM employee_sales;

-- ==========================================
-- LEAD()
-- ==========================================

SELECT emp_name,
       salary,
       LEAD(salary)
       OVER (ORDER BY salary)
       AS next_salary
FROM employee_sales;

-- ==========================================
-- FIRST_VALUE()
-- ==========================================

SELECT emp_name,
       salary,
       FIRST_VALUE(salary)
       OVER (ORDER BY salary)
       AS lowest_salary
FROM employee_sales;

-- ==========================================
-- LAST_VALUE()
-- ==========================================

SELECT emp_name,
       salary,
       LAST_VALUE(salary)
       OVER (
            ORDER BY salary
            ROWS BETWEEN UNBOUNDED PRECEDING
            AND UNBOUNDED FOLLOWING
       ) AS highest_salary
FROM employee_sales;

-- ==========================================
-- NTH_VALUE()
-- ==========================================

SELECT emp_name,
       salary,
       NTH_VALUE(salary, 3)
       OVER (
            ORDER BY salary
            ROWS BETWEEN UNBOUNDED PRECEDING
            AND UNBOUNDED FOLLOWING
       ) AS third_salary
FROM employee_sales;

-- ==========================================
-- NTILE()
-- ==========================================

SELECT emp_name,
       salary,
       NTILE(3)
       OVER (ORDER BY salary DESC)
       AS bucket
FROM employee_sales;