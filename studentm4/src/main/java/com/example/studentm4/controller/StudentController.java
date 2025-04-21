package com.example.studentm4.controller;

import com.example.studentm4.dto.StudentDto;
import com.example.studentm4.model.Student;
import com.example.studentm4.service.impl.IStudentClassService;
import com.example.studentm4.service.impl.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IStudentClassService studentClassService;

    @GetMapping("/show")
    public String showList(Model model){
        model.addAttribute("listStudent",studentService.findAll());
//        model.addAttribute("listClassName",studentClassService.findAll());
        return "/student/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("listClassName",studentClassService.findAll());
        return "/student/create";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){

        Student student =new Student();
        if(bindingResult.hasErrors()){
            model.addAttribute("listClassName", studentClassService.findAll());
            return "student/create";
        }
        BeanUtils.copyProperties(studentDto,student);
        studentService.add(student);
        student.setStudentClass(studentDto.getStudentClass());
        redirectAttributes.addFlashAttribute("success","Thêm mới thành công!");
        return "redirect:/search";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model){
        Student student = studentService.findById(id);
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        model.addAttribute("studentDto",studentDto);
        model.addAttribute("listClassName",studentClassService.findAll());
        return "student/update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute StudentDto studentDto,BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model){
        Student student = new Student();
        if(bindingResult.hasErrors()){
            model.addAttribute("listClassName",studentClassService.findAll());
            return "student/update";
        }
        BeanUtils.copyProperties(studentDto,student);
        studentService.add(student);
        redirectAttributes.addFlashAttribute("success","Cập nhật thành công!");
        return "redirect:/show";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("studentIds") List<Integer> studentIds){
        studentService.deleteAllById(studentIds);
        return "redirect:/show";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam(required = false) String name,
//                         @RequestParam(required = false) Float minPoint,
//                         @RequestParam(required = false) Integer classId, Model model){
//        List<Student> studentList =  studentService.searchStudents(name,minPoint,classId);
//        model.addAttribute("listStudent",studentList);
//        model.addAttribute("listClassName",studentClassService.findAll());
//        return "/student/list";
//    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false,defaultValue = "") String name,
                         @RequestParam(required = false,defaultValue = "") Float minPoint,
                         @RequestParam(required = false,defaultValue = "") Integer classId, Model model,@PageableDefault(size = 2) Pageable pageable){
        Page<Student> studentPage =  studentService.searchStudents(name,minPoint,classId,pageable);
        model.addAttribute("listStudent",studentPage);
//        model.addAttribute("listClassName",studentClassService.findAll());
        model.addAttribute("name",name);
        model.addAttribute("minPoint",minPoint);
        model.addAttribute("classId",classId);
        return "/student/list";
    }

    @GetMapping("/detail/{id}")
    @ResponseBody // Trả về dữ liệu JSON
    public ResponseEntity<Student> getStudentDetail(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
}
