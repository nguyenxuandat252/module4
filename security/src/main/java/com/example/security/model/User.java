package com.example.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<UserRole> userRoleList;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;
    public enum Role{
        ADMIN,
        EMPLOYEE,
        CUSTOMER
    }
}
