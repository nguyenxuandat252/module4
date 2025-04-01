package com.example.blog.repository;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query("SELECT new com.example.blog.dto.BlogDto(b.id,b.code, b.content, b.createTime, b.author.id,b.author.code, b.author.name) FROM Blog b")
    List<BlogDto> getAllBlogs();
    @Query("SELECT new com.example.blog.dto.BlogDto(b.id, b.code, b.content, b.createTime, b.author.id, b.author.code, b.author.name) " +
            "FROM Blog b LEFT JOIN b.author a WHERE a.name LIKE %:name%")
    Page<BlogDto> finByNameBlogDto(String name, Pageable pageable);
    @Query(value = "select b.id,b.code,b.content,b.create_time,b.id_author,a.code,a.name from blog b left join author a on b.id_author = b.id where lower(a.name)  like  lower(%:name%);",nativeQuery = true)
    List<BlogDto> searchByName(@Param("name") String name);
}
