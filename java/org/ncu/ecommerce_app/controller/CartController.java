package org.ncu.ecommerce_app.controller;

import org.ncu.ecommerce_app.entity.Cart;
import org.ncu.ecommerce_app.entity.CartItem;
import org.ncu.ecommerce_app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/add")
    public Cart addItemToCart(@RequestBody Cart cartItem) {
        return cartService.addItemToCart( cartItem);
    }

    @PutMapping("/{userId}/update")
    public CartItem updateCartItem(@PathVariable int userId, @RequestBody CartItem cartItem) {
        return cartService.updateCartItem(userId, cartItem);
    }

    @DeleteMapping("/{userId}/remove/{itemId}")
    public void removeCartItem(@PathVariable Long userId, @PathVariable Long itemId) {
        cartService.removeCartItem(userId, itemId);
    }
}
