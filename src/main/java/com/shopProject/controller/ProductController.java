package com.shopProject.controller;

import com.shopProject.entity.Product;
import com.shopProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }
}
