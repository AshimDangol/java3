package model;

public class Student {
    private int studentId;
    private String studentName;
    private String email;
    private String course;
    private double marks;

    public Student() {}

    public Student(int studentId, String studentName, String email, String course, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "Student [ID=" + studentId + ", Name=" + studentName + ", Email=" + email
                + ", Course=" + course + ", Marks=" + marks + "]";
    }
}
