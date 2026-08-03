# 🛡️ Project Aegis

> **A personal command-line operating system for managing productivity, learning, and self-improvement.**

Project Aegis is a Java-based CLI application I'm building from scratch as a long-term software engineering learning project.

The goal isn't simply to build a productivity tracker. Aegis is my sandbox for learning how real software systems are designed, structured, persisted, refactored, and eventually evolved into a full-stack application.

---

## 🚀 Current Version

**v0.5.0 — Japanese Tracker**

Aegis currently contains three functional tracking modules:

* ✅ Task Manager
* ✅ DSA Tracker
* ✅ Japanese Tracker
* 🚧 Gym Tracker
* 🚧 Dashboard & Analytics

---

# 🎯 Project Goals

Aegis is designed to track:

* 📋 Productivity & Tasks
* 💻 DSA Progress
* 🏋️ Gym Progress
* 🇯🇵 Japanese Learning
* 📊 Personal Statistics

More importantly, the project is helping me develop practical software engineering skills:

* Object-Oriented Programming
* Layered Architecture
* Separation of Concerns
* Clean Code
* CRUD Operations
* Data Persistence
* Dependency Injection
* Refactoring
* Git & Version Control
* Backend Architecture

---

# 🏗️ Architecture

Aegis currently follows a layered architecture:

```text
UI Layer
    ↓
Service Layer
    ↓
Persistence Layer
    ↓
Serialized Data
```

### Project Structure

```text
src/
├── app/
│   └── Main.java
│
├── enums/
│   ├── Category.java
│   ├── Difficulty.java
│   ├── JapaneseType.java
│   ├── Priority.java
│   └── Topics.java
│
├── model/
│   ├── User.java
│   ├── Task.java
│   ├── Problem.java
│   └── Japanese.java
│
├── service/
│   ├── UserService.java
│   ├── TaskService.java
│   ├── DSAService.java
│   └── JapaneseService.java
│
├── storage/
│   └── FileManager.java
│
└── ui/
    ├── ConsoleUI.java
    ├── InputHandler.java
    ├── MenuRenderer.java
    ├── TaskUI.java
    ├── DSAUI.java
    └── JapaneseUI.java
```

The architecture is intentionally evolving as the project grows. Future refactoring will further improve separation of responsibilities and scalability.

---

# 📋 Task Manager

The Task Manager was the first major functional module in Aegis.

### Features

* Create tasks
* Remove tasks
* Edit tasks
* Mark tasks as completed/incomplete
* View all tasks
* Search tasks
* Filter tasks
* Sort tasks
* Assign categories
* Assign priorities
* Set deadlines
* Persistent storage

### Task Data

Each task can contain:

* Title
* Description
* Category
* Priority
* Deadline
* Completion status

---

# 💻 DSA Tracker

The DSA Tracker is designed to record and analyze my algorithm-solving progress.

### Features

* Add problems
* Remove problems
* Edit problems
* View all problems
* Search by difficulty
* Search by topic
* Favorite problems
* Mark problems for revision
* Toggle favorite status
* Toggle revision status
* Persistent storage
* Basic statistics

### Problem Data

Each problem stores:

* Problem name
* LeetCode number
* Difficulty
* Topics
* Date solved
* Notes
* Time taken
* Favorite status
* Revision status

---

# 🇯🇵 Japanese Tracker

**Introduced in v0.5.0**

The Japanese Tracker is the third major tracking module in Aegis.

It is intentionally kept small for its first version so the architecture can be established before adding more advanced learning features.

### Features

* Add Japanese learning items
* Edit Japanese items
* Remove Japanese items
* View all items
* Search by type
* Search by lesson
* Search by mastered status
* Search by revision status
* Track mastered status
* Track revision status
* Store notes
* Persistent storage

### Japanese Item Data

Each item can contain:

* Name
* Type
* Lesson
* Mastered status
* Revision-needed status
* Notes

### Supported Types

```text
VOCAB
KANJI
GRAMMAR
PARTICLE
FORM
```

### Module Architecture

```text
JapaneseUI
     ↓
JapaneseService
     ↓
FileManager
     ↓
japanese.dat
```

---

# 💾 Persistence

Aegis currently uses Java's native object serialization for local persistence.

Data is stored as serialized `.dat` files.

Current persistent modules include:

```text
tasks.dat
problems.dat
japanese.dat
```

The persistence flow is approximately:

```text
Java Object
     ↓
ObjectOutputStream
     ↓
FileOutputStream
     ↓
.dat file
```

And when loading:

```text
.dat file
     ↓
FileInputStream
     ↓
ObjectInputStream
     ↓
Java Object
```

This approach is intentionally simple while I'm learning persistence fundamentals.

A future version will likely migrate to a more robust persistence solution such as:

* JSON
* SQLite
* H2
* PostgreSQL

---

# 🧩 UI Architecture

The original `ConsoleUI` initially handled almost everything.

As Aegis grew, this became difficult to maintain.

The UI was therefore modularized into separate components:

```text
ConsoleUI
├── TaskUI
├── DSAUI
├── JapaneseUI
└── Future:
    └── GymUI
```

`ConsoleUI` now focuses primarily on application-level navigation, while each module owns its own interaction flow.

Shared input parsing is handled by:

```text
InputHandler
```

Static menu layouts are handled by:

```text
MenuRenderer
```

This keeps UI responsibilities separated as more modules are introduced.

---

# 🛠️ Tech Stack

### Current

* **Java**
* Java Collections
* Java OOP
* Java Serialization
* Java `LocalDate`
* Git
* GitHub

### Planned

* Spring Boot
* REST APIs
* PostgreSQL
* React
* Authentication
* AI-assisted features

The long-term goal is to evolve Aegis from a local CLI application into a full-stack personal system.

---

# 📈 Development Roadmap

## v0.1 — Foundation

* Project structure
* User model
* Initial CLI
* Basic navigation

## v0.2 — Task Manager

* Task model
* Task CRUD
* Task service
* Search & sorting

## v0.3 — Persistence & Architecture

* Java serialization
* FileManager
* Persistent task storage
* Improved project structure

## v0.4 — DSA Tracker

* DSA model
* DSA service
* DSA CRUD
* Search/filtering
* Favorites
* Revision tracking
* Persistent DSA storage

## v0.4.5 — UI Modularization

* Split `ConsoleUI`
* Introduce `TaskUI`
* Introduce `DSAUI`
* Improve UI separation
* Add architecture documentation

## v0.5 — Japanese Tracker

* Japanese model
* Japanese service
* Japanese UI
* CRUD
* Search/filtering
* Mastery tracking
* Revision tracking
* Persistent storage

## Next — Gym Tracker

The Gym Tracker will be developed more carefully because it introduces significantly more complex data relationships.

Planned concepts include:

* Workout sessions
* Exercises
* Sets
* Repetitions
* Weight tracking
* Personal records
* Progressive overload
* Workout history
* Analytics

Before starting Gym Tracker, the existing architecture will undergo another refactoring pass to ensure the foundation is strong enough for the increased complexity.

---

# 🔮 Long-Term Vision

The eventual goal is to evolve Aegis into a full-stack personal operating system.

Potential architecture:

```text
                 React Frontend
                       │
                       ▼
                Spring Boot API
                       │
              ┌────────┴────────┐
              ▼                 ▼
         PostgreSQL          AI Layer
              │
              ▼
        Persistent Data
```

Potential future modules:

* Task Management
* DSA Progress
* Gym Tracking
* Japanese Learning
* Habit Tracking
* Personal Dashboard
* Analytics
* Authentication
* Notifications
* AI-powered insights

---

# 📚 Why I'm Building Aegis

Aegis is intentionally being developed incrementally rather than copied from a tutorial.

Each version is an opportunity to learn something new:

```text
OOP
 ↓
Architecture
 ↓
CRUD
 ↓
Persistence
 ↓
Refactoring
 ↓
Testing
 ↓
Backend Development
 ↓
Databases
 ↓
APIs
 ↓
Frontend
 ↓
Full-Stack System
```

The application itself is useful, but the real objective is learning how software evolves from a small idea into a maintainable system.

---

# 📌 Current Status

**Version:** `v0.5.0`

**Functional Modules:**

* ✅ Task Manager
* ✅ DSA Tracker
* ✅ Japanese Tracker
* 🚧 Gym Tracker
* 🚧 Dashboard

**Current focus:**

> Strengthening the architecture before beginning the Gym Tracker.

---

## 🛡️ Project Aegis

**Build it. Break it. Refactor it. Learn from it.**

A long-term engineering project built one version at a time.
