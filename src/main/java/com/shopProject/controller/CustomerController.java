package com.shopProject.controller;

import com.shopProject.entity.Customer;
import com.shopProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers/**")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
