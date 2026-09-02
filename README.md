# 🎓 UGV CGPA Generation System – Java

A **GUI-based CGPA Generation System** developed using **Java Swing** and **Object-Oriented Programming (OOP)** concepts.

This project is designed according to the **University of Global Village (UGV)** grading system and supports both **numeric marks** and **letter grades**.

---

## 📌 Project Overview

The **UGV CGPA Generation System** allows users to enter student information, add multiple courses, provide course credits and grades, and automatically calculate the student's CGPA.

The application provides a graphical user interface using **Java Swing**, making the system simple and user-friendly.

---

## ✨ Features

* 👨‍🎓 Enter student name and student ID
* 📚 Add multiple courses
* 💳 Enter course credit hours
* 🔢 Enter numeric marks (0–100)
* 🔤 Select letter grades manually
* 🔄 Automatically convert marks into UGV letter grades
* 📊 Display courses in a table
* 🧮 Calculate credit-weighted CGPA
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

## 🧮 CGPA Calculation

The system calculates CGPA using a credit-weighted average:

```text
CGPA = Σ(Credit × Grade Point) / Σ(Credit)
```

For each course:

```text
Quality Points = Credit × Grade Point
```

The total quality points are then divided by the total credits.

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

A `Student` contains multiple `Course` objects:

```java
private List<Course> courses;
```

Each `Course` also contains a `Grade` object:

```java
private Grade grade;
```

This creates relationships between the classes and demonstrates practical OOP design.

---

## 🏛️ Class Structure

The project consists of the following main classes:

| Class            | Responsibility                                          |
| ---------------- | ------------------------------------------------------- |
| `Grade`          | Abstract base class for grades                          |
| `LetterGrade`    | Handles letter-based grades                             |
| `NumericGrade`   | Converts marks into grades and grade points             |
| `Course`         | Stores course information and calculates quality points |
| `Student`        | Stores student information and courses                  |
| `CGPACalculator` | Performs CGPA calculation                               |
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
* Course Name field
* Credits field
* Grade Type selection
* Numeric Marks input
* Letter Grade selection
* Course table
* Add Course button
* Calculate CGPA button
* Clear button
* CGPA display

---

## 📂 Project Structure

```text
CSE-4-OOP_CGPA-Generation-System-Java/
│
├── CGPAApp.java
├── .gitignore
└── README.md
```

Compiled `.class` files are excluded from Git using `.gitignore`.

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
3. Enter the **Course Name**.
4. Enter the course **Credits**.
5. Select either:

   * `Numeric Marks`, or
   * `Letter Grade`
6. Enter the marks or select a letter grade.
7. Click **Add Course**.
8. Repeat the process for other courses.
9. Click **Calculate CGPA**.
10. The final CGPA and student information will be displayed.

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

⭐ This project was created for academic learning and practicing Java Object-Oriented Programming concepts.
