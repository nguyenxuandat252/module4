package com.example.thymleaf.service;

import com.example.thymleaf.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void add(Student student);

    Student getById(int id);

    void updateStudent(Student student);

    boolean deleteStudent(int id);

    List<Student> searchName(String keywork);
}
