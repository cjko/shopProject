package com.shopProject.service;

import com.shopProject.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public Customer getCustomerById(int id);
    public void createCustomer(Customer customer);
}
