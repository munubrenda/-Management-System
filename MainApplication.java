// PROJECT: Student Management
// Demonstrates: Encapsulation, Inheritance,  Polymorphism, and Abstraction

import java.util.Scanner;


// STEP 1: ABSTRACTION;  Abstract class Person by properties shared by all people

abstract class Person {

    // Encapsulation: private with final while doesn't change for assignments
    private final String id;
    private final String name;

    // Constructor to  Person
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Abstract method that implement subclass
    public abstract void displayDetails();
}


// STEP 2: INHERITANCE, student class inherits from Person

class Student extends Person {

    // Encapsulation: private with the final attributes
    private final String course;
    private final double marks;

    // Constructor
    public Student(String id, String name, String course, double marks) {
        super(id, name); // Calling parent constructor
        this.course = course;
        this.marks = marks;
    }

    // Getter methods
    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    // STEP 3: POLYMORPHISM, overriding displayDetails from Person

    @Override
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }


    // STEP 4: BUSINESS LOGIG, calculating grade based on marks
    
    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }
}


// STEP 5: MAIN APPLICATION CLASS, Handling user input and program 

public class MainApplication {

    public static void main(String[] args) {

        // Automatically closes Scanner
        try (Scanner scanner = new Scanner(System.in)) {

            
            // STEP 6: CAPTURE STUDENT DATA,  Requirement 1
        

            System.out.println("Enter Student Name:");
            String name = scanner.nextLine();

            System.out.println("Enter Student ID:");
            String id = scanner.nextLine();

            System.out.println("Enter Course:");
            String course = scanner.nextLine();

            System.out.println("Enter Marks:");
            double marks = scanner.nextDouble();

            
            // STEP 7: CREATE STUDENT OBJECT,  Requirement 2
            
            Student student = new Student(id, name, course, marks);

            
            // STEP 8: DISPLAY STUDENT DETAILS,  Requirement 3

            student.displayDetails();
        }
    }
}
