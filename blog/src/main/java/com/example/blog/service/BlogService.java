package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.repository.IAuthorRepository;
import com.example.blog.repository.IBlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    private final IAuthorRepository authorRepository;
    private final IBlogRepository blogRepository;
    @Autowired
    public BlogService(IBlogRepository blogRepository,IAuthorRepository authorRepository){
        this.blogRepository = blogRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        return blogRepository.getAllBlogs();
    }

    @Override
    public void add(BlogDto blogDto) {
        Author author = authorRepository.findByName(blogDto.getAuthorName());
        if(author == null){
            author = new Author();
            author.setCode(blogDto.getAuthorCode());
            author.setName(blogDto.getAuthorName());
            authorRepository.save(author);
        }
        Blog blog = new Blog();
        blog.setCode(blogDto.getBlogCode());
        blog.setContent(blogDto.getContent());
        blog.setCreateTime(blogDto.getCreateTime());
        blog.setAuthor(author);
        blogRepository.save(blog);
    }

    @Override
    public Page<BlogDto> searchByName(String name, Pageable pageable) {
        return blogRepository.finByNameBlogDto(name,pageable);
    }

    @Override
    public List<BlogDto> searchByName(String name) {
        return List.of();
    }
}
