package com.shopProject.dao;

import com.shopProject.entity.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> getProducts();
    public void createProduct(Product product);
}
