# Student Management System

A console-based Student Management System built with Core Java using MVC architecture and DAO design pattern, connected to a PostgreSQL database via JDBC.

## Architecture

```
src/
├── model/       Student.java          — POJO (studentId, studentName, email, course, marks)
├── dao/         StudentDAO.java        — DAO interface (5 CRUD + 2 bonus methods)
│                StudentDAOImpl.java    — JDBC implementation (PreparedStatement, ResultSet)
├── controller/  StudentController.java — Validation, delegates to DAO, returns results to View
├── view/        StudentView.java       — Console menu with Scanner, loops until Exit
├── util/        DBConnection.java      — Singleton-style DB connection helper
└── Main.java                          — Entry point
```

## Features

| # | Option | Description |
|---|--------|-------------|
| 1 | Add Student | Insert new record with validation |
| 2 | View Students | List all records |
| 3 | Search Student | Find by Student ID |
| 4 | Update Student | Modify name, email, course, marks |
| 5 | Delete Student | Remove by Student ID |
| 6 | Sort by Marks | Display students sorted highest-first (bonus) |
| 7 | Display Topper | Show the student with highest marks (bonus) |
| 8 | Exit | Quit application |

## Validation Rules

- Email must contain `@`
- Marks must be between 0 and 100
- Student ID must be unique

## Exception Handling

- `InputMismatchException` for invalid numeric input in View
- `SQLException` wrapped in `RuntimeException` in DAO layer
- Student-not-found messages in Controller

## Prerequisites

- Java 21+ (OpenJDK)
- PostgreSQL running on `localhost:5432`

## Database Setup

```sql
CREATE DATABASE studentdb;
\c studentdb;
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(50),
    marks DOUBLE PRECISION
);
```

## Run

```powershell
javac -cp "lib\*" -d bin src\model\Student.java src\util\DBConnection.java src\dao\StudentDAO.java src\dao\StudentDAOImpl.java src\controller\StudentController.java src\view\StudentView.java Main.java
java -cp "bin;lib\*" Main
```

Update credentials in `src/util/DBConnection.java:7-8` if your PostgreSQL user/password differ from `postgres` / `password`.
