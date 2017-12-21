package com.shopProject.controller;

import com.shopProject.entity.Product;
import com.shopProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products/**")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }
}
