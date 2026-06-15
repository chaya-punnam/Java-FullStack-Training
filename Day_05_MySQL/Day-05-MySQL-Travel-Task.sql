-- =====================================
-- DAY 05 MYSQL TRAVEL TASK
-- =====================================

-- Create Database
CREATE DATABASE travel_db;
USE travel_db;

-- Create Table
CREATE TABLE travel (
    booking_id INT PRIMARY KEY,
    customer_name VARCHAR(50),
    destination VARCHAR(50),
    category VARCHAR(20),
    ticket_price INT,
    passengers INT
);

-- Insert Data
INSERT INTO travel (booking_id, customer_name, destination, category, ticket_price, passengers) VALUES
(1, 'Alice', 'Paris', 'International', 800, 2),
(2, 'Bob', 'New York', 'International', 900, 1),
(3, 'Charlie', 'Tokyo', 'International', 1200, 3),
(4, 'David', 'Miami', 'Domestic', 250, 4),
(5, 'Emma', 'Paris', 'International', 800, 1),
(6, 'Frank', 'Chicago', 'Domestic', 150, 2),
(7, 'Grace', 'Miami', 'Domestic', 250, 2);

-- Q1: Select customer_name and destination for all bookings
SELECT customer_name, destination
FROM travel;

-- Q2: Find all details where category is Domestic
SELECT *
FROM travel
WHERE category = 'Domestic';

-- Q3: Show all unique ticket prices
SELECT DISTINCT ticket_price
FROM travel;

-- Q4: Count total bookings
SELECT COUNT(*) AS total_bookings
FROM travel;

-- Q5: Find total passengers traveling
SELECT SUM(passengers) AS total_passengers
FROM travel;

-- Q6: Find cheapest and costliest ticket price
SELECT MIN(ticket_price) AS cheapest,
       MAX(ticket_price) AS costliest
FROM travel;

-- Q7: Find average ticket price
SELECT AVG(ticket_price) AS average_price
FROM travel;

-- Q8: Find bookings where passengers are more than 2
SELECT *
FROM travel
WHERE passengers > 2;

-- Q9: Count bookings in each category
SELECT category,
       COUNT(*) AS total_bookings
FROM travel
GROUP BY category;

-- Q10: Total passengers for each destination
SELECT destination,
       SUM(passengers) AS total_passengers
FROM travel
GROUP BY destination;

-- Q11: Minimum and maximum ticket price in each category
SELECT category,
       MIN(ticket_price) AS min_price,
       MAX(ticket_price) AS max_price
FROM travel
GROUP BY category;

-- Q12: Destinations having more than 1 booking
SELECT destination,
       COUNT(*) AS booking_count
FROM travel
GROUP BY destination
HAVING COUNT(*) > 1;

-- Q13: Destinations where total passengers are greater than 2
SELECT destination,
       SUM(passengers) AS total_passengers
FROM travel
GROUP BY destination
HAVING SUM(passengers) > 2;

-- Q14: International destinations with average ticket price greater than 800
SELECT destination,
       AVG(ticket_price) AS average_price
FROM travel
WHERE category = 'International'
GROUP BY destination
HAVING AVG(ticket_price) > 800;