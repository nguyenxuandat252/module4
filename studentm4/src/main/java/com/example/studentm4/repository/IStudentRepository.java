package com.example.studentm4.repository;

import com.example.studentm4.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {
    Student findById(int id);

//    @Query("select s from Student s join StudentClass c on s.studentClass.id = c.id WHERE "
//            + "(:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND "
//            + "(:minPoint IS NULL OR s.point >= :minPoint) AND "
//            + "(:classId IS NULL OR s.studentClass.id = :classId)")
//    List<Student> searchStudents(
//            @Param("name") String name,          // Map với :name
//            @Param("minPoint") Float minPoint,   // Map với :minPoint
//            @Param("classId") Integer classId    // Map với :classId
//    );

    @Query("select s from Student s join StudentClass c on s.studentClass.id = c.id WHERE "
            + "(:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND "
            + "(:minPoint IS NULL OR s.point >= :minPoint) AND "
            + "(:classId IS NULL OR s.studentClass.id = :classId)")
    Page<Student> searchStudents(
            @Param("name") String name,          // Map với :name
            @Param("minPoint") Float minPoint,   // Map với :minPoint
            @Param("classId") Integer classId,    // Map với :classId
            Pageable pageable
    );
}
