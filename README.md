# Employee Administration Portal

A beginner-friendly CRUD web application built with JSP, Jakarta Servlets, JDBC and MySQL.

## Requirements
- JDK 11 or later
- Apache Tomcat 10.0+
- MySQL 8+
- Maven

> This project uses `jakarta.servlet` packages and therefore requires Tomcat 10+. For Tomcat 9, the imports and dependencies must be changed to `javax.servlet`.

## Database setup
1. Start MySQL.
2. Run `database/employee_db.sql` in MySQL Workbench or the MySQL command line.
3. Open `src/main/java/com/ems/util/DBConnection.java` and set your MySQL username/password, or set environment variables:
   - `EMS_DB_URL` (optional; default is `jdbc:mysql://localhost:3306/employee_db`)
   - `EMS_DB_USER` (optional; default is `root`)
   - `EMS_DB_PASSWORD` (optional; default is `your_mysql_password`)

## Run
1. Import this folder as an existing Maven project in Eclipse/IntelliJ.
2. Update the database credentials.
3. Build with `mvn clean package`.
4. Deploy `target/EmployeeManagementSystem.war` to Tomcat 10+.
5. Open `http://localhost:8080/EmployeeManagementSystem/`

Demo login:
- Username: `admin`
- Password: `admin123`

The demo login is intentionally simple for a learning project. Do not use plain-text passwords or hard-coded credentials in production applications.

## Features
- Admin login and logout
- Add employee
- View all employees
- Search employee by ID
- Update employee
- Delete employee


