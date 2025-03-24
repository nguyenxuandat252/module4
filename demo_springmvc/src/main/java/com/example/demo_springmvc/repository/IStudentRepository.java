package com.example.demo_springmvc.repository;

import com.example.demo_springmvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();
    void add(Student student);
    boolean delete(int id);
    Student findById(int id);
    boolean edit(int id , Student student);
    List<Student> searchByName(String keyword);
}
