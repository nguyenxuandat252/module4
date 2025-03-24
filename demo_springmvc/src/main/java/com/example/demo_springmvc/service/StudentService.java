package com.example.demo_springmvc.service;

import com.example.demo_springmvc.model.Student;
import com.example.demo_springmvc.repository.IStudentRepository;
import com.example.demo_springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void edit(int id, Student student) {
        studentRepository.edit(id,student);
    }

    @Override
    public List<Student> searchByName(String keyword) {
        return studentRepository.searchByName(keyword);
    }
}
