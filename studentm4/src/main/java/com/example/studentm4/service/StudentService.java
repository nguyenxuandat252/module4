package com.example.studentm4.service;

import com.example.studentm4.model.Student;
import com.example.studentm4.repository.IStudentRepository;
import com.example.studentm4.service.impl.IStudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        studentRepository.deleteAllById(ids);
    }

//    @Override
//    public List<Student> searchStudents(String name, Float minPoint, Integer classId) {
//        return studentRepository.searchStudents(name,minPoint,classId);
//    }

    @Override
    public Page<Student> searchStudents(String name, Float minPoint, Integer classId, Pageable pageable) {
        return studentRepository.searchStudents(name,minPoint,classId,pageable);
    }

}
