package com.example.studentm4.repository;

import com.example.studentm4.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentClassRepository extends JpaRepository<StudentClass,Integer> {
    @Query("delete from Student where id in :ids")
    void deleteAllById(@Param("ids") List<Integer> ids);

}
