package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    Map<ProductDto,Integer> productMap  = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
    public void addProductDto(ProductDto productDto){
        if(productMap.containsKey(productDto)){
            Integer curenValue = productMap.get(productDto);
            productMap.replace(productDto,curenValue+1);
        }else {
            productMap.put(productDto,1);
        }
    }
}
