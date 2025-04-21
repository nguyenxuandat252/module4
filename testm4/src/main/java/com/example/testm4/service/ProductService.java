package com.example.testm4.service;

import com.example.testm4.model.Product;
import com.example.testm4.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
