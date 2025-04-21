package com.example.testm4.controller;

import com.example.testm4.dto.OrderDetailDto;
import com.example.testm4.model.Category;
import com.example.testm4.model.OrderDetail;
import com.example.testm4.model.Product;
import com.example.testm4.service.ICategoryService;
import com.example.testm4.service.IOrderDetailService;
import com.example.testm4.service.IProduct;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProduct productService;
    @GetMapping("/order")
    public String getOrder(Model model, @PageableDefault(size = 5) Pageable pageable){
        Page<OrderDetail> orderDetailList = orderDetailService.getAll(pageable);
        model.addAttribute("orderDetailList", orderDetailList);
        return "/order/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam(required = false,defaultValue = "") LocalDate fromDate,
                         @RequestParam(required = false,defaultValue = "") LocalDate toDate,Model model,@PageableDefault(size = 5) Pageable pageable){
        Page<OrderDetail> orderDetails;
        if (fromDate == null && toDate == null) {
            orderDetails = orderDetailService.getAll(pageable);
        } else {
            orderDetails = orderDetailService.findAllByDateBuyBetween(fromDate,toDate,pageable);
        }
        model.addAttribute("orderDetailList",orderDetails);
        return "/order/list";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model){
        OrderDetail orderDetail = orderDetailService.findById(id);
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        BeanUtils.copyProperties(orderDetail,orderDetailDto);
        List<Category> categoryList = categoryService.findAll();
        List<Product> productList = productService.findAll();
        model.addAttribute("orderDetailDto",orderDetailDto);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("productList",productList);
        return "order/update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute OrderDetailDto orderDetailDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(orderDetailDto,orderDetail);
        orderDetailService.save(orderDetail);
        redirectAttributes.addFlashAttribute("success","Cập nhật thành công!");
        return "redirect:/order";
    }


}
