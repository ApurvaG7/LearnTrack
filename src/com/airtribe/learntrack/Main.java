package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Trainer;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.TrainerService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();
    private static final TrainerService trainerService = new TrainerService();

    public static void main(String[] args) {

        loadSampleData();   // 👈 ADD THIS LINE

        boolean exit = false;

        while (!exit) {
            printMainMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> studentMenu();
                    case 2 -> courseMenu();
                    case 3 -> enrollmentMenu();
                    case 4 -> trainerMenu();
                    case 0 -> {
                        exit = true;
                        System.out.println("Exiting application...");
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // MAIN MENU

    private static void printMainMenu() {
        System.out.println("\n====== MAIN MENU ======");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Trainer Management");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // STUDENT MENU

    private static void studentMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Remove (Deactivate) Student");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudentById();
                case 4 -> updateStudent();
                case 5 -> removeStudent();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // COURSE MENU

    private static void courseMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Course Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Activate Course");
            System.out.println("4. Deactivate Course");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> viewCourses();
                case 3 -> activateCourse();
                case 4 -> deactivateCourse();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ENROLLMENT MENU

    private static void enrollmentMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Enrollment Menu ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments by Student");
            System.out.println("3. Update Enrollment Status");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> enrollStudent();
                case 2 -> viewEnrollmentsByStudent();
                case 3 -> updateEnrollmentStatus();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // TRAINER MENU

    private static void trainerMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Trainer Menu ---");
            System.out.println("1. Add Trainer");
            System.out.println("2. View Trainers");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addTrainer();
                case 2 -> viewTrainers();
                case 0 -> back = true;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // STUDENT METHODS

    private static void addStudent() {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Batch: ");
        String batch = scanner.nextLine();

        System.out.print("Email (press Enter to skip): ");
        String email = scanner.nextLine();

        if (email.isEmpty()) {
            studentService.addStudent(firstName, lastName, batch);
        } else {
            studentService.addStudent(firstName, lastName, email, batch);
        }

        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        System.out.println("\n--- Students ---");
        for (Student s : studentService.listStudents()) {
            System.out.println(
                    s.getId() + " | " +
                            s.getDisplayName() +
                            " | Batch: " + s.getBatch() +
                            " | Active: " + s.isActive()
            );
        }
    }

    private static void searchStudentById() {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Student s = studentService.getStudentById(id);

        System.out.println("\n--- Student Details ---");
        System.out.println("ID: " + s.getId());
        System.out.println("Name: " + s.getDisplayName());
        System.out.println("Batch: " + s.getBatch());
        System.out.println("Email: " + s.getEmail());
        System.out.println("Active: " + s.isActive());
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Student existing = studentService.getStudentById(id);

        System.out.print("New First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("New Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("New Batch: ");
        String batch = scanner.nextLine();

        System.out.print("New Email (press Enter to keep unchanged): ");
        String email = scanner.nextLine();

        if (email.isEmpty()) {
            email = existing.getEmail();
        }

        studentService.updateStudent(id, firstName, lastName, email, batch);
        System.out.println("Student updated successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        studentService.removeStudent(id);
        System.out.println("Student deactivated.");
    }

    // COURSE METHODS

    private static void addCourse() {
        System.out.print("Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Duration (weeks): ");
        int duration = Integer.parseInt(scanner.nextLine());

        courseService.addCourse(name, desc, duration);
        System.out.println("Course added successfully.");
    }

    private static void viewCourses() {
        System.out.println("\n--- Courses ---");
        courseService.listCourses().forEach(c ->
                System.out.println(
                        c.getId() + " | " +
                                c.getCourseName() +
                                " | Active: " + c.isActive()
                )
        );
    }

    private static void activateCourse() {
        System.out.print("Enter Course ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        courseService.activateCourse(id);
        System.out.println("Course activated.");
    }

    private static void deactivateCourse() {
        System.out.print("Enter Course ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        courseService.deactivateCourse(id);
        System.out.println("Course deactivated.");
    }

    // ENROLLMENT METHODS

    private static void enrollStudent() {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        enrollmentService.enrollStudent(studentId, courseId);
        System.out.println("Student enrolled successfully.");
    }

    private static void viewEnrollmentsByStudent() {

        System.out.print("Enter Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        List<Enrollment> enrollments =
                enrollmentService.getEnrollmentsByStudentId(studentId);

        System.out.println("\n--- Enrollments ---");

        for (Enrollment e : enrollments) {

            Student student = studentService.getStudentById(e.getStudentId());
            String studentName = student.getFirstName() + " " + student.getLastName();

            String courseName =
                    courseService.getCourseById(e.getCourseId()).getCourseName();

            System.out.println(
                    "Enrollment ID: " + e.getId() +
                            " | Student: " + studentName +
                            " | Course ID: " + e.getCourseId() +
                            " | Course Name: " + courseName +
                            " | Enrollment Status: " + e.getStatus()
            );
        }
    }


    private static void updateEnrollmentStatus() {
        System.out.print("Enrollment ID: ");
        int enrollmentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Status (ACTIVE / COMPLETED / CANCELLED): ");
        EnrollmentStatus status =
                EnrollmentStatus.valueOf(scanner.nextLine().toUpperCase());

        enrollmentService.updateEnrollmentStatus(enrollmentId, status);
        System.out.println("Enrollment status updated.");
    }

    // TRAINER METHODS

    private static void addTrainer() {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Expertise: ");
        String expertise = scanner.nextLine();

        trainerService.addTrainer(firstName, lastName, email, expertise);
        System.out.println("Trainer added successfully.");
    }

    private static void viewTrainers() {
        System.out.println("\n--- Trainers ---");
        for (Trainer t : trainerService.listTrainers()) {
            System.out.println(
                    t.getId() + " | " +
                            t.getDisplayName() +
                            " | Active: " + t.isActive()
            );
        }
    }

    // PRE-LOADED DATA
    private static void loadSampleData() {


        studentService.addStudent("Amit", "Sharma", "amit@gmail.com", "Java");
        studentService.addStudent("Neha", "Verma", "neha@gmail.com", "Node");
        studentService.addStudent("Rahul", "Patil", "Java"); // without email
        studentService.addStudent("Sneha", "Kulkarni", "sneha@gmail.com", "Node");

        courseService.addCourse("Core Java", "Java fundamentals and OOP", 8);
        courseService.addCourse("DSA", "Data Structures and Algorithms", 10);
        courseService.addCourse("Node", "JavaScript, NodeJS1", 6);

        trainerService.addTrainer("Ankit", "Mehta", "ankit@airtribe.com", "Core Java");
        trainerService.addTrainer("Pooja", "Desai", "pooja@airtribe.com", "DSA");
    }

}
