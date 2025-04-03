package com.example.api.repository;

import com.example.api.dto.StudentDto;
import com.example.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findAll();
    Student getStudentById(int id);
    List<Student> findStudentByNameContainingIgnoreCase(String name);

}
