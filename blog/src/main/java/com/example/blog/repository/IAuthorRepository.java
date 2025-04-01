package com.example.blog.repository;

import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Integer> {
    Author findByName(String name);

}
