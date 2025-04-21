//package com.example.security.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "role_name", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private RoleName role ;
//    public enum RoleName{
//        ADMIN,
//        EMPLOYEE,
//        CUSTOMER
//    }
//
//    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<UserRole> userRoleList;
//}
