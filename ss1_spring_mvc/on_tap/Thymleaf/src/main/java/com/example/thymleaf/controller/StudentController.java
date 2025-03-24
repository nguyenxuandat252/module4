package com.example.thymleaf.controller;

import com.example.thymleaf.model.Student;
import com.example.thymleaf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentList")
    public String showStudentList(Model model) {
        List<Student> studentList = studentService.getAll();
        model.addAttribute("studentList", studentList);
        return "/student/list";
    }

    @GetMapping("/student/add")
    public String showFormAdd(Model model) {
        model.addAttribute("student", new Student());
        return "/student/add";
    }

    @PostMapping("/student/add")
    public String add(@ModelAttribute Student student) {
        studentService.add(student);
        return "redirect:/studentList";
    }

    @GetMapping("/student/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "/student/edit";
    }

    @PostMapping("/student/edit")
    public String edit(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/studentList";
    }

    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("mess", "Đã xóa thành công");
        return "redirect:/studentList";
    }

    @GetMapping("/student/search")
    public String searchName(@RequestParam("keyword") String keyword, Model model) {
        List<Student> students = studentService.searchName(keyword);
        model.addAttribute("studentList", students);
        return "/student/list";
    }
    @GetMapping("/student/detail")
    public String detail(@RequestParam("id") int id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        return "/student/detail";
    }
    @GetMapping("/student/detail/{id}")
    public String detail1(@PathVariable("id") int id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        return "/student/detail";
    }
}
