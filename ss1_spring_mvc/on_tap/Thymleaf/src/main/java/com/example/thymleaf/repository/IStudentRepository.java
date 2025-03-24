package com.example.thymleaf.repository;

import com.example.thymleaf.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();

    void add(Student student);

    boolean deleteStudent(int id);

    Student getById(int id);

    void updateStudent(Student student);

    List<Student> searchName(String keywork);
}
