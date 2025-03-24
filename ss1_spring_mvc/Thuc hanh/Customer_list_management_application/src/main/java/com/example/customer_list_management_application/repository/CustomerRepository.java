package com.example.customer_list_management_application.repository;

import com.example.customer_list_management_application.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    public static List<Customer> customerList  = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Đạt","dat@gmail.com","nghệ an"));
        customerList.add(new Customer(2,"Viet","Viet@gmail.com","Huế"));
        customerList.add(new Customer(3,"Lưu","Luu@gmail.com","Huế"));
    }
    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
