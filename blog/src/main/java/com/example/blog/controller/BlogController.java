package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/list")
public class BlogController {
    private final IBlogService blogService;
    @Autowired
    public BlogController(IBlogService blogService){
        this.blogService=blogService;
    }
    @GetMapping("")
    public String showList(Model model){
        List<BlogDto> blogDtoList = blogService.getAllBlogs();
        model.addAttribute("blogDtoList",blogDtoList);
        return "/views/blog/list";
    }
    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("blogDto",new BlogDto());
        return "/views/blog/add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute BlogDto blogDto) {
       blogService.add(blogDto);
        return "redirect:/list";
    }
    @GetMapping("/search")
    public String showPage(@PageableDefault(size = 2) Pageable pageable, @RequestParam(value = "name",required = false,defaultValue = "")String name, Model model){
        Page<BlogDto> blogDtoPage = blogService.searchByName(name,pageable);
        model.addAttribute("blogDtoPage",blogDtoPage);
        return "/views/blog/list";
    }
}
