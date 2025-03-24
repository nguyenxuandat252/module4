package com.example.customer_list_management_application.repository;

import com.example.customer_list_management_application.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
}
