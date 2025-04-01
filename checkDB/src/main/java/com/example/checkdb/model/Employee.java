package com.example.checkdb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String address;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", nullable = false)
    private EmployeeType employeeType = EmployeeType.ASSISTANT;

    public enum EmployeeType {
        STAFF,
        DRIVER,
        ASSISTANT
    }

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", unique = true)
    private User user;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salary> salaries ;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenanceList;

    @OneToMany(mappedBy = "driver1",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAssignment> employeeAssignmentList;

    @OneToMany(mappedBy = "driver2",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAssignment> employeeAssignmentList1;

    @OneToMany(mappedBy = "assistant",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAssignment> employeeAssignmentList2;
}
