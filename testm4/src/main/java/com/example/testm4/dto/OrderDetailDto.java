package com.example.testm4.dto;

import com.example.testm4.model.Orders;
import com.example.testm4.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Integer id;

    private int quantity;

    private Product product;


    private Orders orders;

}
