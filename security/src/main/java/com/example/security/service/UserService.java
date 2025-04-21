package com.example.security.service;

import com.example.security.dto.UserDto;
import com.example.security.model.User;
import com.example.security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    private IUserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserService(IUserRepository userRepository ){
        this.userRepository=userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<User> finAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean encoded(UserDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encodedPassword);
        user.setRole(userDto.getRole());
        userRepository.save(user);
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean checkLogin(String username,String password) {
        User user = userRepository.findByUsername(username);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            return true;
        }
        return false;
    }
}
