# Project Aegis

> A personal productivity and skill tracking system built from scratch in Java.

Project Aegis is a long-term software engineering project focused on learning software engineering by building a real application from the ground up.

Instead of following tutorials, every feature is designed, implemented, tested, and improved manually.

---

# Current Version

**v0.3.0**

---

# Features

## ✅ User Profile

- Default user creation
- Display profile
- Encapsulation
- Validation
- Custom `toString()`

---

## ✅ Task Manager

### Create

- Add tasks

### Read

- View all tasks

### Update

- Edit title
- Edit description
- Edit category
- Edit priority
- Edit deadline
- Edit completion status

### Delete

- Remove tasks

### Extra Features

- Mark complete/incomplete
- Input validation
- Index validation
- Search by title
- Search by category
- Search by priority
- Sort by title
- Sort by priority
- Sort by deadline

---

## ✅ Persistent Storage

- Save tasks automatically
- Load tasks on startup
- Java Object Serialization
- Binary storage using `tasks.dat`

---

## 🚧 DSA Tracker

Planned

---

## 🚧 Gym Tracker

Planned

---

## 🚧 Japanese Tracker

Planned

---

## 🚧 Dashboard

Planned

---

# Architecture

```text
src/

├── app/
│   └── Main.java
│
├── model/
│   ├── User.java
│   └── Task.java
│
├── service/
│   ├── UserService.java
│   └── TaskService.java
│
├── storage/
│   └── FileManager.java
│
├── enums/
│   ├── Category.java
│   └── Priority.java
│
└── ui/
    └── ConsoleUI.java
```

---

# Technologies

Current

- Java
- Java Serialization
- Object-Oriented Programming

Planned

- SQLite
- JavaFX
- Spring Boot REST API

---

# Roadmap

## ✅ Phase 1

- Project setup
- Models
- Services
- Console UI
- User Profile
- Task Manager

---

## ✅ Phase 2

- File handling
- Automatic saving
- Automatic loading
- Persistent task storage

---

## 🚧 Phase 3

- DSA Tracker
- Gym Tracker
- Japanese Tracker

---

## 🚧 Phase 4

- Dashboard
- Statistics
- Better search
- Better sorting
- User profile persistence

---

## 🚧 Phase 5

- SQLite
- JavaFX GUI
- Analytics
- Reports
- Improved architecture

---

# Learning Goals

- Object-Oriented Programming
- SOLID Principles
- Layered Architecture
- Collections Framework
- Exception Handling
- File Handling
- Object Serialization
- Clean Code
- Git & GitHub Workflow

---

# Current Progress

- ✅ User Module
- ✅ Task Manager
- ✅ Persistent Storage
- ⏳ DSA Tracker
- ⏳ Gym Tracker
- ⏳ Japanese Tracker
- ⏳ Dashboard

---

# Project Status

🟢 Active Development

Project Aegis is being developed feature-by-feature as a software engineering learning project.