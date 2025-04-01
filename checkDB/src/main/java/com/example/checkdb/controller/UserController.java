package com.example.checkdb.controller;

import com.example.checkdb.model.User;
import com.example.checkdb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

}
