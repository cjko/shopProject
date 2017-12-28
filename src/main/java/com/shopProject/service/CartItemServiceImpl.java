package com.shopProject.service;

import com.shopProject.dao.CartItemDAO;
import com.shopProject.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDAO cartItemDAO;

    @Override
    public List<CartItem> getCartItems() {
        return cartItemDAO.getCartItems();
    }

    @Override
    public void createCartItem(int quantity, int customerId, int productId) {
        cartItemDAO.createCartItem(quantity, customerId, productId);
    }

    @Override
    public List<CartItem> getCartItemsByCustomerId(int customerId) {
        return cartItemDAO.getCartItemsByCustomerId(customerId);
    }
}
