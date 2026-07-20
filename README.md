# Project Aegis

> A long-term Java software engineering project focused on building a personal productivity system while learning clean architecture and real-world development practices.

## Overview

Project Aegis is a local Java application that serves as a personal productivity and skill tracker.

Rather than building a typical CRUD application, the goal is to design software that is modular, maintainable, and expandable over time.

The project tracks multiple aspects of personal growth, including:

* 📚 Tasks & Assignments
* 💻 DSA Progress
* 🏋️ Gym Progress
* 🇯🇵 Japanese Learning
* 📊 Personal Statistics

The project is being developed incrementally, following software engineering principles instead of tutorial-driven development.

---

# Tech Stack

* Java
* Maven
* Git & GitHub

### Planned

* File Serialization
* SQLite
* JavaFX
* Spring Boot

---

# Current Project Structure

```text
ProjectAegis
│
├── src
│   ├── main
│   │   └── java
│   │       ├── app
│   │       ├── model
│   │       ├── service
│   │       ├── ui
│   │       ├── enums
│   │       ├── utils
│   │       ├── repository
│   │       ├── storage
│   │       └── exception
│
├── pom.xml
└── README.md
```

---

# Features Completed

## User Module

* [x] User model
* [x] User service
* [x] Display user profile

---

## Task Module

* [x] Task model
* [x] Category enum
* [x] Priority enum
* [x] Task service
* [x] Add tasks
* [x] Remove tasks
* [x] Mark complete / incomplete
* [x] Search by title
* [x] Search by category
* [x] Search by priority
* [x] Sort by title
* [x] Sort by priority
* [x] Sort by deadline

---

## Console UI

* [x] Interactive menu
* [x] Menu loop
* [x] Input validation
* [x] Exit handling

---

# Planned Features

## Dashboard

* Daily overview
* Progress summary
* Statistics
* Current streaks

## DSA Tracker

* Problem tracking
* Topic statistics
* Revision counter
* Difficulty analysis

## Gym Tracker

* Workout history
* Personal records
* Training volume
* Exercise statistics

## Japanese Tracker

* Kanji progress
* Grammar lessons
* Vocabulary count
* Study streak

---

# Development Philosophy

Project Aegis is intentionally developed in small iterations.

Every feature is designed with:

* Clean architecture
* Separation of concerns
* Encapsulation
* Readable code
* Small, focused classes
* Incremental improvements

The objective is not to finish quickly, but to build software that can continue evolving over time.

---

# Current Version

**v0.1.0 (In Development)**

Completed:

* Project architecture
* User module foundation
* Task module foundation
* Interactive console UI
* Input validation

---

# Roadmap

* [ ] Functional Task Manager
* [ ] File persistence
* [ ] Dashboard
* [ ] DSA Tracker
* [ ] Gym Tracker
* [ ] Japanese Tracker
* [ ] SQLite integration
* [ ] JavaFX desktop application
* [ ] Spring Boot REST API

---

# License

This project is developed as a personal learning project and portfolio application.
