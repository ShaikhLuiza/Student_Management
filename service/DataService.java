package service;

import model.Student;
import java.util.List;

public abstract class DataService {
    public abstract void addStudent(Student s);
    public abstract List<Student> getAllStudents();
}
