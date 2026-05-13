# Bank Management System - Maven + JUnit

##  Overview

A console-based Bank Management System developed using Java and upgraded into a Maven project with JUnit 5 testing.

This project was completed as **Intermediate Level Task 1** under the **ShadowFox Internship Program**.

---

##  Features

* Create Bank Account
* Set Account Holder Name
* Set Phone Number
* Deposit Money
* Withdraw Money
* Check Account Balance
* Transaction History Tracking
* Custom Exception Handling
* Thread-Safe Withdrawals using Synchronization
* Unit Testing with JUnit 5
* Maven Project Structure

---

##  Technologies Used

* Java
* Maven
* JUnit 5
* OOP Concepts
* Exception Handling
* Multithreading & Synchronization

---

##  Project Structure

```
bank-management-system-junit
│
├── src
│   ├── main
│   │   └── java/com/shruthan
│   │       ├── BankAccount.java
│   │       ├── Deposit.java
│   │       ├── Withdraw.java
│   │       ├── SwitchHandler.java
│   │       ├── Main.java
│   │       └── InsufficientFundsException.java
│   │
│   └── test
│       └── java/com/shruthan
│           ├── BankAccountTest.java
│           ├── DepositTest.java
│           ├── WithdrawTest.java
│           ├── SwitchHandlerTest.java
│           └── ThreadSafetyTest.java
│
├── pom.xml
└── README.md
```

---

##  Testing

JUnit 5 test cases were added for:

* Deposit Operations
* Withdraw Operations
* Validation Logic
* Insufficient Funds Exception
* Transaction History
* Concurrent Transactions
* Thread Safety

Run tests using:

```bash
mvn test
```

---

## 📸 Sample Console Output

```text
BANK MANAGEMENT SYSTEM
-----------------------------------------
1. Set Account Name
2. Set Account Holder Phone Number
3. Set Initial Balance
4. Deposit Amount
5. Withdraw Amount
6. Check Balance
7. View Transaction History
8. Exit
-----------------------------------------
```

---

## Concepts Learned

* Maven Dependency Management
* Unit Testing with JUnit 5
* Synchronization in Java
* Thread Safety

---

## 👨‍💻 Author

**Shruthan T M**

---
