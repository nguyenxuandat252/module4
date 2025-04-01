package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<BlogDto> getAllBlogs();
    void add(BlogDto blogDto);
    Page<BlogDto> searchByName(String name, Pageable pageable);
    List<BlogDto> searchByName(@Param("name") String name);
}
