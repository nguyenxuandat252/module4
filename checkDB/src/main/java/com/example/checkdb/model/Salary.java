package com.example.checkdb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time", nullable = false)
    private LocalDate dateTime;

    @Column(name = "basic_salary", nullable = false)
    private Double basicSalary;

    private Double reward = 0.0;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee;
}
