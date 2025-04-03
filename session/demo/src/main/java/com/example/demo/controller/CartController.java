package com.example.demo.controller;

import com.example.demo.model.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cart")
public class CartController {

   @GetMapping("")
   public String shopping(@SessionAttribute("cart") CartDto cart, Model model){
    if(cart==null){
        return "redirect:/products";
    }
    model.addAttribute("cart",cart);
    return "/product/cart";
    }

}

