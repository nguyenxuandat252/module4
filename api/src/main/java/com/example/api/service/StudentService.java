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
    public Student updateStudent(StudentDto studentDto) {
        Student student = studentRepository.getStudentById(studentDto.getId());
        if(student==null){
            return null;
        }
        student.setCode(student.getCode());
        student.setName(student.getName());
        student.setAge(student.getAge());
        student.setScore(student.getScore());
        if(studentDto.getClassEntity().getId()>0){
            student.setClassEntity(studentDto.getClassEntity());
        }else {
            throw new RuntimeException("Class not found with ID: " + studentDto.getClassEntity().getId());
        }
        return studentRepository.save(student);
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
