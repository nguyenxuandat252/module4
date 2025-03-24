package com.example.di.service;

import com.example.di.model.Student;
import com.example.di.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;

    //triển khai DI theo constructor Injection(tiêm các đối tượng phụ thuộc vào constructor)
    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
//    triển khai DI theo setter Injection(tiêm các đối tượng phụ thuộc thông qua phương thức setter)
//    @Autowired
//    public void setStudentRepository(IStudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    //    triển khai DI theo Field Injection(tiêm các đối tượng phụ thuộc trực tiếp vào các trường)
//    @Autowired
//    private IStudentRepository studentRepository;
    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }

    @Override
    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> searchName(String keywork) {
        return studentRepository.searchName(keywork);
    }
}
