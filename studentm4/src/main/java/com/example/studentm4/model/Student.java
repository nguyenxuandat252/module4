package com.example.studentm4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private float point;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id")
    private StudentClass studentClass;
}
