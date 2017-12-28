package com.shopProject.controller;

import com.shopProject.entity.CartItem;
import com.shopProject.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cartitems")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CartItem> getCartItems(@RequestParam(value = "customerId", defaultValue = "") String customerId) {

        if(customerId.length() > 0) {
            return cartItemService.getCartItemsByCustomerId(Integer.parseInt(customerId));
        }

        return cartItemService.getCartItems();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createCartItem(@RequestBody String cartItem) {
        JsonParser parser = new BasicJsonParser();
        Map<String, Object> json = parser.parseMap(cartItem);

        int quantity = ((Number) json.get("quantity")).intValue();
        int customerId = ((Number) json.get("customer")).intValue();
        int productId = ((Number) json.get("product")).intValue();

        cartItemService.createCartItem(quantity, customerId, productId);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteCartItem(@RequestBody String cartItem) {
        JsonParser parser = new BasicJsonParser();
        Map<String, Object> json = parser.parseMap(cartItem);

        int customerId = ((Number) json.get("customer")).intValue();
        int productId = ((Number) json.get("product")).intValue();

        cartItemService.deleteCartItem(customerId, productId);
    }

}
