package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService extends DataService {

    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student s) {
        list.add(s);
    }

    @Override
    public List<Student> getAllStudents() {
        return list;
    }
}
