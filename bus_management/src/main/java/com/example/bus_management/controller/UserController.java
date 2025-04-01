package com.example.bus_management.controller;

import com.example.bus_management.dto.UserDTO;
import com.example.bus_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDTO") UserDTO userDTO, Model model) {
        String message = userService.registerUser(userDTO);
        model.addAttribute("message", message);
        return "user/register";
    }
}
