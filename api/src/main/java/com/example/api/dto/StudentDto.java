package com.example.api.dto;


import com.example.api.model.ClassEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {
    private int id;
    private String code;
    private String name;
    private int age;
    private double score;
    private ClassEntity classEntity;
}
