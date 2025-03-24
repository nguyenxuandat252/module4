package com.example.demo_springmvc.repository;

import com.example.demo_springmvc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student("Đạt", 1));
        studentList.add(new Student("Việt", 2));
        studentList.add(new Student("Lưu", 3));
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
    public boolean delete(int id) {
        return studentList.removeIf(student -> student.getId() == id);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean edit(int id, Student student) {
        Student student1 = findById(id);
        if (student1 != null) {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getId() == id) {
                    studentList.set(i, student);
                    return true;
                }
            }

        }
        return false;

    }

    @Override
    public List<Student> searchByName(String keyword) {
        List<Student> students= new ArrayList<>();
        for (Student student: studentList){
            if(student.getName().toLowerCase().contains(keyword.toLowerCase())){
                students.add(student);
                return students;
            }
        }
        return null;
    }


}
