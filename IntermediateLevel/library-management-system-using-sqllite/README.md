# Library Management System Using SQLite

A desktop-based Library Management System built using Java Swing, SQLite, JDBC, Maven, and JUnit 5.

This project was developed as part of the **ShadowFox Intermediate Level - Task 2** internship task.

---

# Features

* Add Books
* Remove Books
* Add Borrowers
* Remove Borrowers
* Checkout Management
* SQLite Database Integration
* SQL Injection Protection using PreparedStatement
* Foreign Key Constraints
* JTable-based Dynamic GUI
* Input Validation & Exception Handling
* Automatic Table Refresh
* Maven Project Structure
* JUnit 5 Test Cases

---

# Technologies Used

* Java 21
* Java Swing
* JDBC
* SQLite
* Maven
* JUnit 5

---

# Project Structure

```text
ShadowFox
│
├── IntermediateLevel
│   └── library-management-system-using-sqllite
│       │
│       ├── pom.xml
│       ├── library.db
│       │
│       ├── src
│       │   ├── main
│       │   │   └── java
│       │   │       └── com
│       │   │           └── shruthan
│       │   │               ├── Database.java
│       │   │               └── LibraryManagement.java
│       │   │
│       │   └── test
│       │       └── java
│       │           └── com
│       │               └── shruthan
│       │                   └── DatabaseTest.java
│       │
│       └── README.md
```

---

# How to Run

## Clone Repository

```bash
git clone https://github.com/shruthan650/ShadowFox.git
```

## Navigate to Project

```bash
cd ShadowFox/IntermediateLevel/library-management-system-using-sqllite
```

## Build Project

```bash
mvn clean install
```

## Run Application

```bash
mvn exec:java
```

---

# Database Tables

## Books Table

| Column           | Description         |
| ---------------- | ------------------- |
| id               | Unique Book ID      |
| title            | Book Title          |
| author           | Author Name         |
| genre            | Book Genre          |
| publication_date | Publication Date    |
| isbn             | ISBN Number         |
| available        | Availability Status |

---

## Borrowers Table

| Column  | Description        |
| ------- | ------------------ |
| id      | Unique Borrower ID |
| name    | Borrower Name      |
| email   | Borrower Email     |
| phone   | Phone Number       |
| address | Borrower Address   |

---

## Checkouts Table

| Column        | Description            |
| ------------- | ---------------------- |
| id            | Checkout ID            |
| book_id       | Referenced Book ID     |
| borrower_id   | Referenced Borrower ID |
| checkout_date | Date Borrowed          |
| due_date      | Due Date               |
| return_date   | Return Date            |

---

# Security Features

* SQL Injection Prevention using PreparedStatement
* Foreign Key Enforcement
* Input Validation
* Exception Handling
* try-with-resources for automatic resource management

---

---

# Learning Outcomes

This project helped improve understanding of:

* Java Desktop Application Development
* Swing GUI Programming
* JDBC Connectivity
* Database Relationships & Constraints
* Secure SQL Query Handling
* Maven Dependency Management
* Unit Testing with JUnit 5

---

# Author

**Shruthan T M**
