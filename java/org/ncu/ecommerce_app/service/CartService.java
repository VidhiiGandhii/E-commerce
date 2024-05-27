package org.ncu.ecommerce_app.service;

import org.ncu.ecommerce_app.entity.Cart;
import org.ncu.ecommerce_app.entity.CartItem;

public interface CartService {

	   Cart getCartByUserId(Long userId);
	    Cart addItemToCart( Cart cartItem);
	    CartItem updateCartItem(int cartItemId, CartItem cartItem);
	    void removeCartItem(Long userId,Long cartItemId);
}
