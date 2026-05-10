# GUI Based Contact Management System (Java Swing)

A GUI-based Contact Management System developed using Java Swing as part of the ShadowFox Beginner Level Projects.

## Features

- Add new contacts
- Update existing contacts
- Delete contacts
- Display contacts using JTable
- Email validation using Regex
- Phone number validation
- Duplicate email checking
- Duplicate phone number checking
- Exception handling using try-catch
- Interactive GUI using Java Swing

## Technologies Used

- Java
- Java Swing
- JTable
- DefaultTableModel
- OOP Concepts
- ArrayList
- Regex
- Exception Handling

## Project Structure

```
GUIBasedContactManagementSystem
│
├── src
│   ├── Main.java
│   ├── TableUI.java
│   ├── ContactStructure.java
│   ├── ExceptionHandler.java
│   ├── AddContactAction.java
│   ├── DeleteContactAction.java
│   ├── UpdateContactAction.java
│   └── TableSelectionAction.java
│
├── .gitignore
└── README.md
```

## How to Run

Open terminal inside src folder

```
javac *.java
java Main
```

## GUI Features

### JTable Integration

 1. Displays contacts in tabular format
 2. Supports row selection
 3. Automatically updates UI after CRUD operations

### CRUD Operations

 1. Add Contact
 2. Update Contact
 3. Delete Contact

### Validation Rules

 Email Validation
    Must contain @
    Prevents invalid email formats
    Duplicate emails are not allowed
 
 Phone Number Validation
    Must contain exactly 10 digits
    Duplicate phone numbers are not allowed
 
## Concepts Practiced
  Java Swing
  JTable and DefaultTableModel
  Event Handling
  ActionListeners
  OOP Concepts
  Modular Programming
  Exception Handling
  Regex Validation

## Author

Shruthan T M
