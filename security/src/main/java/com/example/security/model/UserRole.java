//package com.example.security.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_user", nullable = false)
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "id_role", nullable = false)
//    private Role role;
//}
