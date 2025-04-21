package com.example.internationalization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping
    public String showCustomerList() {
        return "customerL ist"; // Đảm bảo trả về đúng đường dẫn tới view trong `WEB-INF/views/`
    }
}