package com.example.thymleaf.repository;

import com.example.thymleaf.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "dat", true, 9.9));
        studentList.add(new Student(2, "viet", false, 8));
        studentList.add(new Student(3, "luu", false,7));
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student getById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == student.getId()) {
                studentList.set(i, student);
            }
        }
    }

    @Override
    public List<Student> searchName(String keywork) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(keywork)) {
                students.add(student);
            }
        }
        return students;
    }
}
