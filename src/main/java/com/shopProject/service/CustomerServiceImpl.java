package com.shopProject.service;

import com.shopProject.dao.CustomerDAO;
import com.shopProject.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerDAO.createCustomer(customer);
    }
}
