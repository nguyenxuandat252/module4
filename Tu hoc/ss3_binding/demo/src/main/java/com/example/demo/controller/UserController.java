package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    //    @PostMapping("/register")
//    public ModelAndView registerUser(@ModelAttribute("user") User user){
//        ModelAndView modelAndView = new ModelAndView("/userDetail");
//        return modelAndView;
//    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "/userDetail";
    }

    @GetMapping("/register")
    public String formRegister(Model model) {
        model.addAttribute("user", new User());
        return "/form";
    }
}
