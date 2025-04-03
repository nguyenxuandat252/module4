package com.example.demo.controller;

import com.example.demo.model.CartDto;
import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    public IProductService productService;
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public String showList(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);
        return "/product/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        Product product = productService.getById(id);
        model.addAttribute("product",product);
        return "/product/detail";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute("cart") CartDto cart,Model model){
        Product product = productService.getById(id);
        if(product!=null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProductDto(productDto);
        }

        return "redirect:/cart";
    }
}
