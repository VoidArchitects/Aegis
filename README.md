# Project Aegis

> A personal operating system for tracking productivity, skills, and self-improvement progress.

Project Aegis is a long-term software engineering project built from scratch in Java.

The goal is not just to create an application, but to learn real software engineering concepts by designing, building, debugging, and improving a real-world system.

Instead of following tutorials, every feature is independently designed and implemented while focusing on:

- Clean architecture
- Object-oriented design
- Data persistence
- Maintainable code structure
- Real software development workflow

---

# Current Version

**v0.4.0**

---

# Overview

Project Aegis is designed as a personal productivity and growth tracker containing multiple modules:

```
Project Aegis

├── User Profile
├── Task Manager
├── DSA Tracker
├── Gym Tracker
├── Japanese Tracker
└── Future Analytics Dashboard
```

Each module follows a layered architecture:

```
User Interface
      |
      ↓
Service Layer
      |
      ↓
Model Layer
      |
      ↓
Storage Layer
```

---

# Features

# ✅ User Profile

Current features:

- Default user creation
- Display user information
- Encapsulation
- Input validation
- Custom formatted output

---

# ✅ Task Manager

A complete productivity tracking module.

## Create

- Add tasks

## Read

- View all tasks

## Update

- Edit task title
- Edit description
- Edit category
- Edit priority
- Edit deadline
- Edit completion status

## Delete

- Remove tasks

## Additional Features

- Mark complete/incomplete
- Search by title
- Search by category
- Search by priority
- Sort by title
- Sort by priority
- Sort by deadline
- Input validation
- Index validation

---

# ✅ Persistent Storage

Project Aegis uses Java Object Serialization for local data persistence.

Implemented:

- Automatic saving
- Automatic loading
- Binary file storage
- Persistent objects using `.dat` files

Current storage:

```
src/data/

├── tasks.dat
└── problems.dat
```

Technology:

- ObjectOutputStream
- ObjectInputStream
- FileInputStream
- FileOutputStream

---

# ✅ DSA Tracker

A LeetCode-based problem tracking system.

Current features:

## Problem Management

- Add solved problems
- Remove problems
- Edit problem information
- View all problems

## Problem Information

Tracks:

- Problem name
- LeetCode number
- Difficulty
- Topics
- Date solved
- Notes
- Time taken
- Favorite status
- Revision status

## Search

- Search by difficulty
- Search by topic

## Statistics

- Count Easy problems
- Count Medium problems
- Count Hard problems

---

# 🚧 Gym Tracker

Planned module for tracking:

- Workout sessions
- Exercises
- Personal records
- Progressive overload
- Training history

---

# 🚧 Japanese Tracker

Planned module for tracking:

- Vocabulary
- Kanji
- Grammar progress
- Lessons
- Exam preparation

---

# 🚧 Analytics Dashboard

Future module for:

- Productivity statistics
- DSA progress graphs
- Fitness progress
- Learning analytics
- Personal growth insights

---

# Architecture

Current structure:

```
src/

├── app/
│   └── Main.java
│
├── model/
│   ├── User.java
│   ├── Task.java
│   └── Problem.java
│
├── service/
│   ├── UserService.java
│   ├── TaskService.java
│   └── DSAService.java
│
├── storage/
│   └── FileManager.java
│
├── enums/
│   ├── Category.java
│   ├── Priority.java
│   ├── Difficulty.java
│   └── Topic.java
│
└── ui/
    ├── ConsoleUI.java
    ├── InputHandler.java
    └── MenuRenderer.java
```

---

# Technologies

## Current

- Java
- Object-Oriented Programming
- Java Collections Framework
- Java Serialization
- File Handling
- Git & GitHub

## Planned

- SQLite Database
- JavaFX GUI
- Spring Boot REST API
- Web Dashboard
- Analytics System

---

# Development Roadmap

## ✅ Phase 1: Foundation

Completed:

- Project setup
- Model classes
- Service classes
- Console interface
- User module
- Task Manager

---

## ✅ Phase 2: Persistence

Completed:

- File handling system
- Object serialization
- Automatic saving/loading
- Persistent task storage

---

## ✅ Phase 3: DSA Tracker

Completed:

- Problem model
- DSA service layer
- CRUD operations
- Search functionality
- Persistent DSA storage
- Console interface

---

## 🚧 Phase 4: Personal Tracking Modules

Upcoming:

- Gym Tracker
- Japanese Tracker
- Improved UI structure
- Better validation
- More statistics

---

## 🚧 Phase 5: Application Upgrade

Future:

- Database migration
- GUI application
- Dashboard
- Analytics
- Reports
- Cloud synchronization

---

# Learning Goals

Through Project Aegis, the goal is to master:

## Programming

- Object-Oriented Programming
- Encapsulation
- Abstraction
- Interfaces
- Collections Framework
- Generics
- Exception Handling

## Software Engineering

- Layered architecture
- Separation of concerns
- Clean code principles
- Version control
- Debugging workflow
- Refactoring

## Backend Concepts

- File persistence
- Serialization
- Database concepts
- API design

---

# Current Progress

```
✅ User Profile

✅ Task Manager

✅ Persistent Storage

✅ DSA Tracker

⏳ Gym Tracker

⏳ Japanese Tracker

⏳ Dashboard

⏳ Database Migration

⏳ GUI Application
```

---

# Git Development

Project Aegis follows incremental development using Git commits.

Example milestones:

```
feat(storage): add task persistence using Java serialization

feat: implement persistent task storage and improved taskmanager

feat(dsa): implement complete DSA tracker with persistence and CRUD operations
```

---

# Project Status

🟢 Active Development

Project Aegis is continuously evolving from a simple console application into a complete personal productivity and skill tracking system.

Built feature-by-feature, learning engineering principles through actual implementation.