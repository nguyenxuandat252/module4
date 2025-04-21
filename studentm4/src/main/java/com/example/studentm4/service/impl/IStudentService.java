package com.example.studentm4.service.impl;

import com.example.studentm4.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student);
    Student findById(int id);
    void deleteAllById(@Param("ids") List<Integer> ids);

//    List<Student> searchStudents(
//            @Param("name") String name,          // Map với :name
//            @Param("minPoint") Float minPoint,   // Map với :minPoint
//            @Param("classId") Integer classId    // Map với :classId
//    );

    Page<Student> searchStudents(
            @Param("name") String name,          // Map với :name
            @Param("minPoint") Float minPoint,   // Map với :minPoint
            @Param("classId") Integer classId,    // Map với :classId
            Pageable pageable
    );

}
