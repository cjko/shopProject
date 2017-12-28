package com.shopProject.controller;

import com.shopProject.entity.Customer;
import com.shopProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Customer> getCustomers(@RequestParam(value = "email", defaultValue = "") String email) {
        if(email.length()>0) {
            return customerService.getCustomersByEmail(email);
        }
        return customerService.getCustomers();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        System.out.println(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable String id) {
        int customerId = Integer.parseInt(id);
        return customerService.getCustomerById(customerId);
    }

}
