package com.example.api.controller;

import com.example.api.dto.StudentDto;

import com.example.api.model.ClassEntity;
import com.example.api.model.Student;
import com.example.api.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/students")
public class RestStudentController {
    private IStudentService studentService;

    @Autowired
    public RestStudentController(IStudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping
    public ResponseEntity<List<Student>> getList(){
        List<Student> studentDtoList = studentService.getAllStudents();
        if(studentDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(studentDtoList,HttpStatus.OK); //200
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.addStudent(student);
        return new ResponseEntity<>("Success",HttpStatus.CREATED); //201
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@RequestBody StudentDto studentDto){
        studentService.updateStudent(studentDto);
        if(studentService.updateStudent(studentDto)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Student>> search(@RequestParam String name){
        List<Student> studentList = studentService.searchStudents(name);
        if(studentList==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

}
