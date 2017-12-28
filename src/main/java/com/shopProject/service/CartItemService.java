package com.shopProject.service;

import com.shopProject.entity.CartItem;

import java.util.List;

public interface CartItemService {
    public List<CartItem> getCartItems();
    public void createCartItem(int quantity, int customerId, int productId);
    public List<CartItem> getCartItemsByCustomerId(int customerId);
}
