package controller;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

public class StudentController {
    private StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentDAOImpl();
    }

    public String addStudent(int id, String name, String email, String course, double marks) {
        if (!email.contains("@")) {
            return "Invalid email: must contain '@'";
        }
        if (marks < 0 || marks > 100) {
            return "Invalid marks: must be between 0 and 100";
        }
        if (studentDAO.getStudentById(id) != null) {
            return "Student ID " + id + " already exists";
        }
        Student student = new Student(id, name, email, course, marks);
        studentDAO.addStudent(student);
        return "Student added successfully!";
    }

    public String getAllStudents() {
        java.util.List<Student> list = studentDAO.getAllStudents();
        if (list.isEmpty()) {
            return "No students found.";
        }
        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    public String getStudentById(int id) {
        Student s = studentDAO.getStudentById(id);
        if (s == null) {
            return "Student with ID " + id + " not found.";
        }
        return s.toString();
    }

    public String updateStudent(int id, String name, String email, String course, double marks) {
        if (!email.contains("@")) {
            return "Invalid email: must contain '@'";
        }
        if (marks < 0 || marks > 100) {
            return "Invalid marks: must be between 0 and 100";
        }
        if (studentDAO.getStudentById(id) == null) {
            return "Student with ID " + id + " not found.";
        }
        Student student = new Student(id, name, email, course, marks);
        boolean updated = studentDAO.updateStudent(student);
        return updated ? "Student updated successfully!" : "Update failed.";
    }

    public String deleteStudent(int id) {
        if (studentDAO.getStudentById(id) == null) {
            return "Student with ID " + id + " not found.";
        }
        boolean deleted = studentDAO.deleteStudent(id);
        return deleted ? "Student deleted successfully!" : "Delete failed.";
    }

    public String getStudentsSortedByMarks() {
        java.util.List<Student> list = studentDAO.getStudentsSortedByMarks();
        if (list.isEmpty()) {
            return "No students found.";
        }
        StringBuilder sb = new StringBuilder("=== Students Sorted by Marks (Highest First) ===\n");
        for (Student s : list) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    public String getTopperStudent() {
        Student s = studentDAO.getTopperStudent();
        if (s == null) {
            return "No students found.";
        }
        return "=== Topper Student ===\n" + s;
    }
}
