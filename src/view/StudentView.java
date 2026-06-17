package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.StudentController;

public class StudentView {
    private StudentController controller;
    private Scanner scanner;

    public StudentView() {
        this.controller = new StudentController();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Display Topper Student");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateStudent();
                    case 5 -> deleteStudent();
                    case 6 -> sortStudents();
                    case 7 -> showTopper();
                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice! Enter 1-8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter a number.");
                scanner.nextLine();
            }
        }
    }

    private void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();
            System.out.println(controller.addStudent(id, name, email, course, marks));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct values.");
            scanner.nextLine();
        }
    }

    private void viewStudents() {
        System.out.println(controller.getAllStudents());
    }

    private void searchStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println(controller.getStudentById(id));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter a valid ID.");
            scanner.nextLine();
        }
    }

    private void updateStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter New Course: ");
            String course = scanner.nextLine();
            System.out.print("Enter New Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();
            System.out.println(controller.updateStudent(id, name, email, course, marks));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct values.");
            scanner.nextLine();
        }
    }

    private void deleteStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println(controller.deleteStudent(id));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter a valid ID.");
            scanner.nextLine();
        }
    }

    private void sortStudents() {
        System.out.println(controller.getStudentsSortedByMarks());
    }

    private void showTopper() {
        System.out.println(controller.getTopperStudent());
    }
}
