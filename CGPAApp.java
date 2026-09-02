import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


// ============================================================
// ABSTRACT GRADE CLASS
// ============================================================

abstract class Grade {

    // Encapsulation
    private String gradeValue;

    public Grade(String gradeValue) {
        setGradeValue(gradeValue);
    }

    // Getter
    public String getGradeValue() {
        return gradeValue;
    }

    // Setter
    public void setGradeValue(String gradeValue) {

        if (gradeValue == null || gradeValue.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Grade cannot be empty."
            );
        }

        this.gradeValue = gradeValue.trim().toUpperCase();
    }

    // Abstract method
    // Child classes must override this method
    public abstract double getGradePoint();
}


// ============================================================
// LETTER GRADE CLASS
// ============================================================

class LetterGrade extends Grade {

    public LetterGrade(String gradeValue) {
        super(gradeValue);
    }

    // Method overriding
    @Override
    public double getGradePoint() {

        switch (getGradeValue()) {

            case "A+":
                return 4.00;

            case "A":
                return 3.75;

            case "A-":
                return 3.50;

            case "B+":
                return 3.25;

            case "B":
                return 3.00;

            case "B-":
                return 2.75;

            case "C+":
                return 2.50;

            case "C":
                return 2.25;

            case "D":
                return 2.00;

            case "F":
                return 0.00;

            default:
                throw new IllegalArgumentException(
                        "Invalid UGV letter grade: "
                                + getGradeValue()
                );
        }
    }
}


// ============================================================
// NUMERIC GRADE CLASS
// ============================================================

class NumericGrade extends Grade {

    // Encapsulation
    private double marks;

    public NumericGrade(double marks) {

        // Temporary value.
        // The actual grade is calculated from marks.
        super("Numeric");

        setMarks(marks);
    }

    // Getter
    public double getMarks() {
        return marks;
    }

    // Setter with validation
    public void setMarks(double marks) {

        if (marks < 0 || marks > 100) {

            throw new IllegalArgumentException(
                    "Marks must be between 0 and 100."
            );
        }

        this.marks = marks;
    }

    // --------------------------------------------------------
    // Convert UGV marks to letter grade
    // --------------------------------------------------------

    public String getLetterGrade() {

        if (marks >= 80) {
            return "A+";
        }
        else if (marks >= 75) {
            return "A";
        }
        else if (marks >= 70) {
            return "A-";
        }
        else if (marks >= 65) {
            return "B+";
        }
        else if (marks >= 60) {
            return "B";
        }
        else if (marks >= 55) {
            return "B-";
        }
        else if (marks >= 50) {
            return "C+";
        }
        else if (marks >= 45) {
            return "C";
        }
        else if (marks >= 40) {
            return "D";
        }
        else {
            return "F";
        }
    }

    // --------------------------------------------------------
    // Method overriding
    // --------------------------------------------------------

    @Override
    public double getGradePoint() {

        if (marks >= 80) {
            return 4.00;
        }
        else if (marks >= 75) {
            return 3.75;
        }
        else if (marks >= 70) {
            return 3.50;
        }
        else if (marks >= 65) {
            return 3.25;
        }
        else if (marks >= 60) {
            return 3.00;
        }
        else if (marks >= 55) {
            return 2.75;
        }
        else if (marks >= 50) {
            return 2.50;
        }
        else if (marks >= 45) {
            return 2.25;
        }
        else if (marks >= 40) {
            return 2.00;
        }
        else {
            return 0.00;
        }
    }
}


// ============================================================
// COURSE CLASS
// ============================================================

class Course {

    // Private fields = Encapsulation
    private String courseName;
    private double credits;
    private Grade grade;

    public Course(
            String courseName,
            double credits,
            Grade grade) {

        setCourseName(courseName);
        setCredits(credits);
        setGrade(grade);
    }

    // Getter
    public String getCourseName() {
        return courseName;
    }

    // Setter
    public void setCourseName(String courseName) {

        if (courseName == null ||
                courseName.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Course name cannot be empty."
            );
        }

        this.courseName = courseName.trim();
    }

    // Getter
    public double getCredits() {
        return credits;
    }

    // Setter
    public void setCredits(double credits) {

        if (credits <= 0) {

            throw new IllegalArgumentException(
                    "Credits must be greater than 0."
            );
        }

        this.credits = credits;
    }

    // Getter
    public Grade getGrade() {
        return grade;
    }

    // Setter
    public void setGrade(Grade grade) {

        if (grade == null) {

            throw new IllegalArgumentException(
                    "Grade cannot be null."
            );
        }

        this.grade = grade;
    }

    // Calculate quality points
    public double getQualityPoints() {

        return credits * grade.getGradePoint();
    }
}


// ============================================================
// STUDENT CLASS
// ============================================================

class Student {

    // Private fields = Encapsulation
    private String name;
    private String studentId;

    private List<Course> courses;

    public Student(
            String name,
            String studentId) {

        setName(name);
        setStudentId(studentId);

        courses = new ArrayList<>();
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {

        if (name == null ||
                name.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Student name cannot be empty."
            );
        }

        this.name = name.trim();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    // Setter
    public void setStudentId(String studentId) {

        if (studentId == null ||
                studentId.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Student ID cannot be empty."
            );
        }

        this.studentId = studentId.trim();
    }

    // Getter
    public List<Course> getCourses() {
        return courses;
    }

    // Add course
    public void addCourse(Course course) {

        if (course == null) {

            throw new IllegalArgumentException(
                    "Course cannot be null."
            );
        }

        courses.add(course);
    }
}


// ============================================================
// CGPA CALCULATOR CLASS
// ============================================================

class CGPACalculator {

    // Prevent object creation
    private CGPACalculator() {
    }

    // Weighted CGPA calculation
    public static double calculateCGPA(Student student) {

        if (student == null) {

            throw new IllegalArgumentException(
                    "Student cannot be null."
            );
        }

        double totalQualityPoints = 0.0;
        double totalCredits = 0.0;

        // Calculate:
        // CGPA = Sum(Credit × Grade Point) / Sum(Credit)

        for (Course course : student.getCourses()) {

            totalQualityPoints +=
                    course.getQualityPoints();

            totalCredits +=
                    course.getCredits();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalQualityPoints / totalCredits;
    }
}


// ============================================================
// MAIN SWING APPLICATION
// ============================================================

public class CGPAApp extends JFrame {

    private Student student;

    // Student fields
    private JTextField nameField;
    private JTextField idField;

    // Course fields
    private JTextField courseField;
    private JTextField creditsField;
    private JTextField marksField;

    // Grade type
    private JComboBox<String> gradeTypeCombo;

    // Letter grade
    private JComboBox<String> letterGradeCombo;

    // Table
    private JTable courseTable;
    private DefaultTableModel tableModel;

    // CGPA
    private JLabel cgpaLabel;


    // ========================================================
    // CONSTRUCTOR
    // ========================================================

    public CGPAApp() {

        setTitle("UGV CGPA Generation System");

        setSize(900, 700);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createGUI();
    }


    // ========================================================
    // CREATE GUI
    // ========================================================

    private void createGUI() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(10, 10)
                );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );


        // ----------------------------------------------------
        // TITLE
        // ----------------------------------------------------

        JLabel titleLabel =
                new JLabel(
                        "UGV CGPA GENERATION SYSTEM",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );


        mainPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );


        // ----------------------------------------------------
        // FORM PANEL
        // ----------------------------------------------------

        JPanel formPanel =
                new JPanel(
                        new GridLayout(
                                7,
                                2,
                                10,
                                10
                        )
                );

        formPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Student & Course Information"
                )
        );


        // Student Name

        formPanel.add(
                new JLabel("Student Name:")
        );

        nameField =
                new JTextField();

        formPanel.add(nameField);


        // Student ID

        formPanel.add(
                new JLabel("Student ID:")
        );

        idField =
                new JTextField();

        formPanel.add(idField);


        // Course Name

        formPanel.add(
                new JLabel("Course Name:")
        );

        courseField =
                new JTextField();

        formPanel.add(courseField);


        // Credits

        formPanel.add(
                new JLabel("Credits:")
        );

        creditsField =
                new JTextField();

        formPanel.add(creditsField);


        // Grade Type

        formPanel.add(
                new JLabel("Grade Type:")
        );

        gradeTypeCombo =
                new JComboBox<>(
                        new String[]{
                                "Numeric Marks",
                                "Letter Grade"
                        }
                );

        formPanel.add(
                gradeTypeCombo
        );


        // Marks

        formPanel.add(
                new JLabel("Marks (0-100):")
        );

        marksField =
                new JTextField();

        formPanel.add(
                marksField
        );


        // Letter Grade

        formPanel.add(
                new JLabel("Letter Grade:")
        );

        letterGradeCombo =
                new JComboBox<>(
                        new String[]{
                                "A+",
                                "A",
                                "A-",
                                "B+",
                                "B",
                                "B-",
                                "C+",
                                "C",
                                "D",
                                "F"
                        }
                );

        letterGradeCombo.setEnabled(false);

        formPanel.add(
                letterGradeCombo
        );


        // ----------------------------------------------------
        // TABLE
        // ----------------------------------------------------

        String[] columns = {

                "Course",
                "Credits",
                "Grade",
                "Grade Point",
                "Quality Points"
        };


        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                );


        courseTable =
                new JTable(tableModel);


        courseTable.setRowHeight(25);


        JScrollPane scrollPane =
                new JScrollPane(courseTable);


        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Course List"
                )
        );


        // ----------------------------------------------------
        // CENTER PANEL
        // ----------------------------------------------------

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(10, 10)
                );


        centerPanel.add(
                formPanel,
                BorderLayout.NORTH
        );


        centerPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );


        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );


        // ----------------------------------------------------
        // BUTTONS
        // ----------------------------------------------------

        JButton addButton =
                new JButton(
                        "Add Course"
                );


        JButton calculateButton =
                new JButton(
                        "Calculate CGPA"
                );


        JButton clearButton =
                new JButton(
                        "Clear"
                );


        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout()
                );


        buttonPanel.add(
                addButton
        );


        buttonPanel.add(
                calculateButton
        );


        buttonPanel.add(
                clearButton
        );


        // ----------------------------------------------------
        // CGPA LABEL
        // ----------------------------------------------------

        cgpaLabel =
                new JLabel(
                        "CGPA: 0.00",
                        SwingConstants.CENTER
                );


        cgpaLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );


        JPanel bottomPanel =
                new JPanel(
                        new BorderLayout()
                );


        bottomPanel.add(
                buttonPanel,
                BorderLayout.NORTH
        );


        bottomPanel.add(
                cgpaLabel,
                BorderLayout.SOUTH
        );


        mainPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );


        // ----------------------------------------------------
        // ADD COURSE BUTTON
        // ----------------------------------------------------

        addButton.addActionListener(
                e -> addCourse()
        );


        // ----------------------------------------------------
        // CALCULATE BUTTON
        // ----------------------------------------------------

        calculateButton.addActionListener(
                e -> calculateCGPA()
        );


        // ----------------------------------------------------
        // CLEAR BUTTON
        // ----------------------------------------------------

        clearButton.addActionListener(
                e -> clearForm()
        );


        // ----------------------------------------------------
        // GRADE TYPE CHANGE
        // ----------------------------------------------------

        gradeTypeCombo.addActionListener(e -> {

            boolean numericMode =
                    gradeTypeCombo
                            .getSelectedItem()
                            .equals(
                                    "Numeric Marks"
                            );


            marksField.setEnabled(
                    numericMode
            );


            letterGradeCombo.setEnabled(
                    !numericMode
            );
        });


        add(mainPanel);
    }


    // ========================================================
    // ADD COURSE
    // ========================================================

    private void addCourse() {

        try {

            // ------------------------------------------------
            // STUDENT INFORMATION
            // ------------------------------------------------

            String name =
                    nameField
                            .getText()
                            .trim();


            String id =
                    idField
                            .getText()
                            .trim();


            if (name.isEmpty()) {

                throw new IllegalArgumentException(
                        "Please enter student name."
                );
            }


            if (id.isEmpty()) {

                throw new IllegalArgumentException(
                        "Please enter student ID."
                );
            }


            // ------------------------------------------------
            // CREATE STUDENT
            // ------------------------------------------------

            if (student == null) {

                student =
                        new Student(
                                name,
                                id
                        );
            }


            // ------------------------------------------------
            // COURSE NAME
            // ------------------------------------------------

            String courseName =
                    courseField
                            .getText()
                            .trim();


            if (courseName.isEmpty()) {

                throw new IllegalArgumentException(
                        "Please enter course name."
                );
            }


            // ------------------------------------------------
            // CREDITS
            // ------------------------------------------------

            double credits =
                    Double.parseDouble(
                            creditsField
                                    .getText()
                                    .trim()
                    );


            if (credits <= 0) {

                throw new IllegalArgumentException(
                        "Credits must be greater than 0."
                );
            }


            // ------------------------------------------------
            // CREATE GRADE
            // ------------------------------------------------

            Grade grade;

            String gradeDisplay;


            boolean numericMode =
                    gradeTypeCombo
                            .getSelectedItem()
                            .equals(
                                    "Numeric Marks"
                            );


            if (numericMode) {

                // --------------------------------------------
                // NUMERIC MARKS
                // --------------------------------------------

                String marksText =
                        marksField
                                .getText()
                                .trim();


                if (marksText.isEmpty()) {

                    throw new IllegalArgumentException(
                            "Please enter marks."
                    );
                }


                double marks =
                        Double.parseDouble(
                                marksText
                        );


                // Polymorphism
                grade =
                        new NumericGrade(
                                marks
                        );


                NumericGrade numericGrade =
                        (NumericGrade) grade;


                // Automatically determine UGV grade

                gradeDisplay =
                        numericGrade.getLetterGrade();


            } else {

                // --------------------------------------------
                // LETTER GRADE
                // --------------------------------------------

                String letter =
                        (String)
                                letterGradeCombo
                                        .getSelectedItem();


                // Polymorphism
                grade =
                        new LetterGrade(
                                letter
                        );


                gradeDisplay =
                        letter;
            }


            // ------------------------------------------------
            // CREATE COURSE
            // ------------------------------------------------

            Course course =
                    new Course(
                            courseName,
                            credits,
                            grade
                    );


            // ------------------------------------------------
            // ADD COURSE TO STUDENT
            // ------------------------------------------------

            student.addCourse(
                    course
            );


            // ------------------------------------------------
            // ADD COURSE TO TABLE
            // ------------------------------------------------

            tableModel.addRow(
                    new Object[]{

                            course.getCourseName(),

                            String.format(
                                    "%.2f",
                                    course.getCredits()
                            ),

                            gradeDisplay,

                            String.format(
                                    "%.2f",
                                    grade.getGradePoint()
                            ),

                            String.format(
                                    "%.2f",
                                    course.getQualityPoints()
                            )
                    }
            );


            // ------------------------------------------------
            // CLEAR COURSE INPUT
            // ------------------------------------------------

            courseField.setText("");

            creditsField.setText("");

            marksField.setText("");


            // ------------------------------------------------
            // SUCCESS MESSAGE
            // ------------------------------------------------

            JOptionPane.showMessageDialog(
                    this,

                    "Course added successfully!\n"
                            + "UGV Grade: "
                            + gradeDisplay
                            + "\nGrade Point: "
                            + String.format(
                                    "%.2f",
                                    grade.getGradePoint()
                            ),

                    "Course Added",

                    JOptionPane.INFORMATION_MESSAGE
            );


        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,

                    "Please enter valid numbers for "
                            + "credits and marks.",

                    "Input Error",

                    JOptionPane.ERROR_MESSAGE
            );


        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                    this,

                    ex.getMessage(),

                    "Validation Error",

                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ========================================================
    // CALCULATE CGPA
    // ========================================================

    private void calculateCGPA() {

        if (student == null ||
                student.getCourses().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,

                    "Please add at least one course.",

                    "No Courses",

                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        // Calculate weighted CGPA

        double cgpa =
                CGPACalculator.calculateCGPA(
                        student
                );


        // Display CGPA

        cgpaLabel.setText(
                String.format(
                        "CGPA: %.2f",
                        cgpa
                )
        );


        // Calculate total credits

        double totalCredits = 0;

        for (Course course :
                student.getCourses()) {

            totalCredits +=
                    course.getCredits();
        }


        // ----------------------------------------------------
        // RESULT MESSAGE
        // ----------------------------------------------------

        JOptionPane.showMessageDialog(
                this,

                "Student Name: "
                        + student.getName()

                        + "\nStudent ID: "
                        + student.getStudentId()

                        + "\nTotal Courses: "
                        + student.getCourses().size()

                        + "\nTotal Credits: "
                        + String.format(
                                "%.2f",
                                totalCredits
                        )

                        + "\n\nUGV CGPA: "
                        + String.format(
                                "%.2f",
                                cgpa
                        ),

                "CGPA Result",

                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // ========================================================
    // CLEAR EVERYTHING
    // ========================================================

    private void clearForm() {

        nameField.setText("");

        idField.setText("");

        courseField.setText("");

        creditsField.setText("");

        marksField.setText("");


        tableModel.setRowCount(0);


        cgpaLabel.setText(
                "CGPA: 0.00"
        );


        student = null;
    }


    // ========================================================
    // MAIN METHOD
    // ========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CGPAApp app =
                    new CGPAApp();

            app.setVisible(true);
        });
    }
}