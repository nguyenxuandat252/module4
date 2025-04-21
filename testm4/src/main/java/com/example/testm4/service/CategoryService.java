package com.example.testm4.service;

import com.example.testm4.model.Category;
import com.example.testm4.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
