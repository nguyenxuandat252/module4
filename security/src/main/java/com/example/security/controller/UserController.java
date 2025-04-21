package com.example.security.controller;

import com.example.security.dto.UserDto;
import com.example.security.model.User;
import com.example.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showFormRegister(Model model) {
        model.addAttribute("user", new UserDto());
        return "views/user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDto userDto, Model model, RedirectAttributes redirectAttributes) {
        List<User> userList = userService.finAll();
        if (userList != null) {
            for (User user : userList) {
                if (user.getUsername().equals(userDto.getUsername())) {
                    model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
                    return "views/user/register";
                } else if (!userDto.getPassword().equals(userDto.getPasswordConfirm())) {
                    model.addAttribute("error", "Mật khẩu không trùng khớp!");
                    return "views/user/register";
                }
            }
        }
        userService.encoded(userDto);
        redirectAttributes.addFlashAttribute("user", userDto);
        model.addAttribute("success", "Đăng ký thành công!");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showFormLogin(Model model) {
        model.addAttribute("user", new UserDto());
        return "views/user/login";
    }
    @GetMapping("/403")
    public String accessDenied() {
        return "views/user/403"; // trả về trang thông báo lỗi quyền truy cập
    }

//    @PostMapping("/doLogin")
//    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
//        if (userService.checkLogin(username,password)) {
//            model.addAttribute("success", "Đăng nhập thành công!");
//            return "/views/user/home";
//        }
//        model.addAttribute("error", "Tài khoản và mật khẩu chưa đúng!");
//        return "/views/user/login";
//    }
    @GetMapping("/home")
    public String showHome() {
        return "views/user/home";
    }

    @GetMapping("/admin")
    public String showAdmin() {
        return "views/user/admin";
    }

}


