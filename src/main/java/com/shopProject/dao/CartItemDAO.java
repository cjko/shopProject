package com.shopProject.dao;

import com.shopProject.entity.CartItem;

import java.util.List;

public interface CartItemDAO {
    public List<CartItem> getCartItems();
    public void createCartItem(int quantity, int customerId, int productId);
    public List<CartItem> getCartItemsByCustomerId(int customerId);
    public void deleteCartItem(int customerId, int productId);
}
