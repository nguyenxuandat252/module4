package com.example.api.service;

import com.example.api.dto.StudentDto;
import com.example.api.model.Student;
import com.example.api.repository.IStudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class StudentService implements IStudentService{
    private IStudentRepository studentRepository;
    @Autowired
    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student student1 = studentRepository.getStudentById(student.getId());
        if(student1==null){
            return null;
        }
        student1.setCode(student.getCode());
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setScore(student.getScore());
        return studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchStudents(String keyword) {
        return studentRepository.findStudentByNameContainingIgnoreCase(keyword);
    }
}
