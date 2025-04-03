package com.example.api.service;

import com.example.api.dto.StudentDto;
import com.example.api.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(int id);
    List<Student> searchStudents(String keyword);
}
