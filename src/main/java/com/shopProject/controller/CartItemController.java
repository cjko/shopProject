package com.shopProject.controller;

import com.shopProject.entity.CartItem;
import com.shopProject.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cartitems/**")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @RequestMapping("/")
    public List<CartItem> getCartItems() {
        return cartItemService.getCartItems();
    }
}
