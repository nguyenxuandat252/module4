package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ProductService implements IProductService {
    private IProductRepository productRepository;
    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private final List<Product> products = Arrays.asList(
            new Product(1,"1L", "Laptop",true, 1500.0,1200.0, "laptop.jpg"),
            new Product(2,"2L", "Smartphone",false, 800.0,600.0, "phone.jpg"),
            new Product(3,"3L", "Headphones",true, 200.0,150.0, "headphones.jpg")
    );
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
