CREATE DATABASE IF NOT EXISTS employee_db;
USE employee_db;

CREATE TABLE IF NOT EXISTS admin (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);

INSERT INTO admin(username, password)
VALUES ('admin', 'admin123')
ON DUPLICATE KEY UPDATE username = username;

CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    department VARCHAR(80) NOT NULL,
    salary DECIMAL(10,2) NOT NULL
);

INSERT INTO employees(name, email, department, salary)
VALUES ('Arun Kumar', 'arun@example.com', 'IT', 35000.00),
       ('Priya S', 'priya@example.com', 'HR', 32000.00);
