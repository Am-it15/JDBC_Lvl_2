#  Student Management System - JDBC Dynamic Statements


## 🚀 Project Overview
This is a **Student Management System** built in **Java** using **JDBC Dynamic Statements**.  
It allows you to **add, update, delete, and retrieve student records** from a database.

This project demonstrates **dynamic SQL queries**, which are constructed as strings and executed at runtime.

---

## 🧠 Why Dynamic Statements?
Dynamic statements allow SQL queries to be created on the fly.  
⚠️ **Warning:** They are vulnerable to SQL Injection and are generally not recommended for production.

**Pros:**
- Simple to implement
- Flexible runtime query generation

**Cons:**
- SQL Injection risk
- Harder to maintain
- Slower than PreparedStatements

---

## 📌 Features
- Add new student records (`addStudent`)
- Update existing student details (`updateStudent`)
- Delete student records (`dltStudent`)
- Retrieve student information (`retrieveStudent`)

---