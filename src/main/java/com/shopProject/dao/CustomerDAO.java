package com.shopProject.dao;

import com.shopProject.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public Customer getCustomerById(int id);
    public void createCustomer(Customer customer);
}
