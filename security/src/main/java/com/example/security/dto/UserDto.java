package com.example.security.dto;

import com.example.security.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserDto {
        private int id;
        private String username;
        private String password;
        private String passwordConfirm;
        private User.Role role = User.Role.CUSTOMER;
    }
