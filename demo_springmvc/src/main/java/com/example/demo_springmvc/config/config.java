package com.example.demo_springmvc.config;

import com.example.demo_springmvc.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class config {
    @Bean
    public StudentRepository studentRepository(){
        return new  StudentRepository();
    }
}
