package com.example.session_cookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("loggedUser")
public class LoginController {
    @GetMapping("/login")
    public String showLoginPage(){
        return "views/login/login";
    }
    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          Model model){
        if("admin".equals(username)&&"123".equals(password)){
            model.addAttribute("loggedUser",username);
            return "redirect:/home";
        }
        else {
            return "redirect:/login?error=true";
        }
    }
    @GetMapping("/home")
    public String home(Model model){
        if (!model.containsAttribute("loggedUser")){
            return "redirect:views/login/login";
        }
        return "/views/login/home";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // Xóa session
        return "redirect:/login";
    }
}
