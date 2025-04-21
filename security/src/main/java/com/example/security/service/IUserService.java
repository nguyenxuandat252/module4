package com.example.security.service;

import com.example.security.dto.UserDto;
import com.example.security.model.User;

import java.util.List;

public interface IUserService {
    List<User> finAll();
    boolean encoded(UserDto userDto);
    User findByUsername(String username);
    boolean checkLogin(String username,String password);
}
