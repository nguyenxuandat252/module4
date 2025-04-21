package com.example.studentm4.service;

import com.example.studentm4.model.Student;
import com.example.studentm4.model.StudentClass;
import com.example.studentm4.repository.IStudentClassRepository;
import com.example.studentm4.service.impl.IStudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentClassService implements IStudentClassService {
    @Autowired
    private IStudentClassRepository studentClassRepository;
    @Override
    public List<StudentClass> findAll() {
        return studentClassRepository.findAll();
    }
}
