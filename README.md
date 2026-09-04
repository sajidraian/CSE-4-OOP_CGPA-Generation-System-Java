# 🎓 UGV CGPA Generation System – Java

A **GUI-based CGPA Generation System** developed using **Java Swing** and **Object-Oriented Programming (OOP)** concepts.

This project is designed according to the **University of Global Village (UGV)** grading system. It supports both **numeric marks** and **letter grades**, and allows students to manage their results across **Semester 1 to Semester 8**.

---

## 📌 Project Overview

The **UGV CGPA Generation System** allows users to enter student information, select a semester, add multiple courses, provide course credits and grades, and automatically calculate both **semester GPA** and **overall CGPA**.

The application provides a graphical user interface using **Java Swing**, making the system simple and user-friendly.

Courses are organized separately by semester, allowing the user to update and manage academic results from **Semester 1 through Semester 8**.

---

## ✨ Features

* 👨‍🎓 Enter student name and student ID
* 📚 Add multiple courses
* 🎓 Select semester from **Semester 1 to Semester 8**
* 💳 Enter course credit hours
* 🔢 Enter numeric marks (0–100)
* 🔤 Select letter grades manually
* 🔄 Automatically convert marks into UGV letter grades
* 📊 Display courses in a table
* 📈 Calculate **semester-wise GPA**
* 🧮 Calculate **overall credit-weighted CGPA**
* 🔄 Switch between semesters and view the selected semester GPA
* 📋 Display total courses and total credits
* ⚠️ Input validation and error handling
* 🧹 Clear all entered information
* 🖥️ User-friendly Java Swing GUI

---

## 🎯 UGV Grading System

The application follows the following grading scale:

|    Marks | Letter Grade | Grade Point |
| -------: | :----------: | ----------: |
|   80–100 |      A+      |        4.00 |
|    75–79 |       A      |        3.75 |
|    70–74 |      A-      |        3.50 |
|    65–69 |      B+      |        3.25 |
|    60–64 |       B      |        3.00 |
|    55–59 |      B-      |        2.75 |
|    50–54 |      C+      |        2.50 |
|    45–49 |       C      |        2.25 |
|    40–44 |       D      |        2.00 |
| Below 40 |       F      |        0.00 |

---

## 📚 Semester Management

The system supports **8 semesters**:

```text
Semester 1
Semester 2
Semester 3
Semester 4
Semester 5
Semester 6
Semester 7
Semester 8
```

Each semester has its own list of courses.

For example:

```text
Semester 1
 ├── Course 1
 ├── Course 2
 └── Course 3

Semester 2
 ├── Course 1
 ├── Course 2
 └── Course 3

Semester 3
 ├── Course 1
 └── Course 2

...

Semester 8
 ├── Course 1
 └── Course 2
```

This allows courses to be added to the correct semester without mixing results from different semesters.

---

## 🧮 GPA and CGPA Calculation

### Semester GPA

The GPA of each semester is calculated using the credit-weighted formula:

```text
Semester GPA =
Σ(Credit × Grade Point) / Σ(Credit)
```

For each course:

```text
Quality Points = Credit × Grade Point
```

For example:

```text
Course A
Credit = 3
Grade Point = 4.00

Quality Points = 3 × 4.00
               = 12.00
```

The quality points of all courses in the semester are added and divided by the total semester credits.

---

### Overall CGPA

The overall CGPA is calculated using **all courses from all semesters**:

```text
Overall CGPA =
Σ(All Course Quality Points) / Σ(All Course Credits)
```

This means the system uses a **credit-weighted CGPA**, rather than simply averaging the semester GPAs.

For example:

```text
Semester 1 GPA = 3.40
Semester 2 GPA = 3.60
Semester 3 GPA = 3.75
```

The final CGPA is calculated from the actual course credits and grade points across all semesters.

---

## 🏗️ OOP Concepts Used

This project demonstrates several important **Object-Oriented Programming concepts**.

### 1. Encapsulation

Private fields are used with public getters and setters.

Examples:

```java
private String name;
private String studentId;
private double marks;
```

Validation is also performed inside setter methods.

---

### 2. Abstraction

`Grade` is an abstract class that defines the common structure for different types of grades.

```java
abstract class Grade {
    public abstract double getGradePoint();
}
```

---

### 3. Inheritance

`LetterGrade` and `NumericGrade` inherit from the `Grade` abstract class.

```text
             Grade
            /     \
           /       \
  LetterGrade   NumericGrade
```

---

### 4. Polymorphism

The program uses the `Grade` reference to work with different grade implementations.

```java
Grade grade;

grade = new NumericGrade(marks);
```

or:

```java
grade = new LetterGrade(letter);
```

The same `getGradePoint()` method behaves differently depending on the actual object.

---

### 5. Method Overriding

Both child classes override the abstract `getGradePoint()` method.

```java
@Override
public double getGradePoint()
```

---

### 6. Composition / Object Relationships

A `Student` contains multiple semesters, and each semester contains multiple `Course` objects.

Each `Course` also contains a `Grade` object.

Conceptually:

```text
Student
  |
  ├── Semester 1
  │     ├── Course
  │     ├── Course
  │     └── Course
  │
  ├── Semester 2
  │     ├── Course
  │     └── Course
  │
  ├── Semester 3
  │     └── Course
  │
  ...
  │
  └── Semester 8
        ├── Course
        └── Course
```

This demonstrates practical relationships between objects and improves the organization of semester-wise academic data.

---

## 🏛️ Class Structure

The project consists of the following main classes:

| Class            | Responsibility                                          |
| ---------------- | ------------------------------------------------------- |
| `Grade`          | Abstract base class for grades                          |
| `LetterGrade`    | Handles letter-based grades                             |
| `NumericGrade`   | Converts marks into grades and grade points             |
| `Course`         | Stores course information and calculates quality points |
| `Student`        | Stores student information and semester-wise courses    |
| `CGPACalculator` | Performs semester GPA and overall CGPA calculations     |
| `CGPAApp`        | Creates the Java Swing GUI and handles user interaction |

### Class Relationship

```text
                    Grade
                   /     \
                  /       \
         LetterGrade    NumericGrade
                             
                    ↑
                    |
                  Course
                    ↑
                    |
              Student
             /       \
            /         \
     Semester 1 ... Semester 8
            |
         Courses

             CGPACalculator
                    |
                    ↓
                  Student

                 CGPAApp
                    |
                    ↓
                  Student
```

---

## 🖥️ Graphical User Interface

The application is built using **Java Swing**.

The GUI includes:

* Student Name field
* Student ID field
* Semester selection
* Course Name field
* Credits field
* Grade Type selection
* Numeric Marks input
* Letter Grade selection
* Course table
* Add Course button
* Calculate CGPA button
* Clear button
* Semester GPA display
* Overall CGPA display

---

## 📊 Semester-Wise Results

The application allows the user to select a semester and see its GPA.

For example:

```text
Selected Semester: 4

Semester 4 GPA: 3.52
Overall CGPA: 3.47
```

When the semester selection is changed, the displayed semester GPA is updated automatically.

---

## 📂 Project Structure

```text
CSE-4-OOP_CGPA-Generation-System-Java/
│
├── CGPAApp.java
├── .gitignore
└── README.md
```

Compiled `.class` files should be excluded from Git using `.gitignore`.

---

## ▶️ How to Run

### Requirements

* Java JDK
* VS Code / IntelliJ IDEA / Eclipse
* Git (optional, for cloning the repository)

### Compile

Open the project folder in a terminal and run:

```bash
javac CGPAApp.java
```

### Run

```bash
java CGPAApp
```

The **UGV CGPA Generation System** window will open.

---

## 📝 How to Use

1. Enter the **Student Name**.
2. Enter the **Student ID**.
3. Select the required **Semester (1–8)**.
4. Enter the **Course Name**.
5. Enter the course **Credits**.
6. Select either:

   * `Numeric Marks`, or
   * `Letter Grade`
7. Enter the marks or select a letter grade.
8. Click **Add Course**.
9. Repeat the process for other courses in the same semester.
10. Select another semester when you want to add courses for that semester.
11. Click **Calculate CGPA** to calculate the selected semester GPA and overall CGPA.
12. Use the semester selector to view the GPA of different semesters.

---

## 🛡️ Input Validation

The application validates user input, including:

* Empty student name
* Empty student ID
* Empty course name
* Invalid credits
* Marks outside the `0–100` range
* Empty grade values
* Invalid letter grades
* Invalid numeric input
* Attempting to calculate without adding courses

Error messages are displayed using Java Swing dialog boxes.

---

## 🧰 Technologies Used

* **Java**
* **Java Swing**
* **Object-Oriented Programming**
* **ArrayList / List**
* **Git**
* **GitHub**

---

## 🎓 Academic Information

**University:** University of Global Village (UGV)
**Course:** Object-Oriented Programming (OOP)
**Project:** UGV CGPA Generation System
**Programming Language:** Java

---

## 👨‍💻 Author

**Sajid Al Raian**

---

⭐ This project was created for academic learning and practicing **Java Object-Oriented Programming**, including encapsulation, abstraction, inheritance, polymorphism, composition, and GUI development.

---
