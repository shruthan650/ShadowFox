# Contact Management System (Java)

A simple Java-based Contact Management System developed as part of the ShadowFox Beginner Level Project 2.

## Features

- Create a contact
- Read/Search a contact
- Update contact details
- Delete a contact
- Email validation using Regex
- Phone number validation
- Duplicate email checking
- Duplicate phone number checking
- Exception handling for invalid inputs

## Technologies Used

- Java
- OOP Concepts
- ArrayList
- Scanner Class
- Regex
- Exception Handling

## Project Structure

```plaintext
ContactManagementSystem
│
├── src
│   ├── Main.java
│   ├── ContactStructure.java
│   ├── CreateOperation.java
│   ├── ReadOperation.java
│   ├── UpdateOperation.java
│   ├── DeleteOperation.java
│   └── ExceptionHandler.java
│
├── .gitignore
└── README.md
```

## How to Run

Open terminal inside src folder

```
bash
javac *.java
java Main
```

## Sample Menu

```
1. Create a contact
2. Read a contact
3. Update a contact
4. Delete a contact
5. Exit
```
## Validation Rules

1. Email Validation
2. Must contain @
3. Prevents invalid email formats
4. Duplicate emails are not allowed

Phone Number Validation

1. Must contain exactly 10 digits
2. Duplicate phone numbers are not allowed

## Author
Shruthan T M
