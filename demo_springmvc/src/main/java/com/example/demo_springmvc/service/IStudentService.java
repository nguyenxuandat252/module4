package com.example.demo_springmvc.service;

import com.example.demo_springmvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    void add(Student student);
    boolean delete(int id);
    Student findById(int id);
    void edit(int id , Student student);
    List<Student> searchByName(String keyword);
}
