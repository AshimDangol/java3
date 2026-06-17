package dao;

import java.util.List;
import model.Student;

public interface StudentDAO {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
    List<Student> getStudentsSortedByMarks();
    Student getTopperStudent();
}
