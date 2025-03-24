package com.example.demo_springmvc.controller;

import com.example.demo_springmvc.model.Student;
import com.example.demo_springmvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/students")
    public String showList(Model model){
        List<Student> studentList = studentService.getAll();
        model.addAttribute("studentList",studentList);
        return "student/list";
    }
    @GetMapping("/students/create")
    public String showFormCreate(Model model){
        model.addAttribute("student",new Student());
        return "student/create";
    }
    @PostMapping("/students/create")
    public  String save(@ModelAttribute Student student){
        studentService.add(student);
        return "redirect:/students";
    }
    @PostMapping("/students/delete")
    public  String delete(@RequestParam("id")int id){
//        List<Student> studentList = studentService.getAll();
        studentService.delete(id);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String showFromEdit(@PathVariable int id,Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "student/edit";
    }
    @PostMapping("/students/edit")
    public String edit(@ModelAttribute Student student){
        studentService.edit(student.getId(),student);
        return "redirect:/students";
    }
    @PostMapping("/students/search")
    public String search(@RequestParam("name")String name, Model model){
        List<Student> students = studentService.searchByName(name);
        model.addAttribute("studentList",students);
        return "student/list";
    }
}
