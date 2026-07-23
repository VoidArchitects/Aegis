# Project Aegis

> Your personal productivity and skill tracking system, built from scratch in Java.

Project Aegis is a long-term software engineering project focused on building a personal productivity operating system while learning clean architecture, object-oriented design, data persistence, and scalable application development.

Rather than following tutorials, the project is built feature-by-feature to simulate real software development.

---

# Current Version

**v0.2.0**

---

# Features

## ✅ User Profile

- Create default user
- Display profile
- Clean User model
- Encapsulation
- Validation
- `toString()` implementation

---

## ✅ Task Manager (CRUD)

### Create

- Add task

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

- Remove task

### Other

- Mark complete
- Mark incomplete
- Index validation
- Category & Priority enums
- Helper input methods
- Search methods (service)
- Sorting methods (service)

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

```
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
├── enums/
│   ├── Category.java
│   └── Priority.java
│
└── ui/
    └── ConsoleUI.java
```

---

# Technologies

- Java
- Maven

Future

- File Serialization
- SQLite
- JavaFX
- Spring Boot REST API

---

# Roadmap

## Phase 1 ✅

- Project setup
- Models
- Services
- Console UI
- User Profile
- Task Manager CRUD

---

## Phase 2 (Next)

- Save tasks to file
- Load tasks automatically
- Persistent user profile

---

## Phase 3

- DSA Tracker
- Gym Tracker
- Japanese Tracker

---

## Phase 4

- Dashboard
- Statistics
- Search improvements
- Sorting improvements

---

## Phase 5

- SQLite
- JavaFX
- Better architecture
- Reports
- Analytics

---

# Learning Goals

- Object-Oriented Programming
- Clean Code
- Layered Architecture
- Collections Framework
- Exception Handling
- File Handling
- Serialization
- Design Thinking
- Git Workflow

---

# Current Progress

- ✅ User Module
- ✅ Task Module
- ⏳ Persistent Storage
- ⏳ Remaining Trackers
- ⏳ Dashboard

---

# Project Status

Actively under development.