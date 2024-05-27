package org.ncu.ecommerce_app.service;

import org.ncu.ecommerce_app.dao.CartDao;
import org.ncu.ecommerce_app.entity.Cart;
import org.ncu.ecommerce_app.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartDao.findById(userId);
    }

    @Override
    public Cart addItemToCart( Cart cartItem) {
       return cartDao.save(cartItem);
    }

    @Override
public CartItem updateCartItem(int cartItemId, CartItem updatedCartItem) {
    Cart cart = cartDao.findById(updatedCartItem.getCart().getId());
    if (cart != null) {
        CartItem cartItemToUpdate = cart.getItems().get(cartItemId);
        if (cartItemToUpdate != null) {
            // Update the cart item properties
            cartItemToUpdate.setQuantity(updatedCartItem.getQuantity());
            cartItemToUpdate.setProduct(updatedCartItem.getProduct());
            // Save the updated cart
            cartDao.save(cart);
            return cartItemToUpdate;
        }
    }
    return null;
}


    @Override
    public void removeCartItem(Long userId, Long cartItemId) {
        Cart cart = cartDao.findById(userId);
        if (cart != null) {
            cartDao.deleteById(cartItemId);
            cartDao.save(cart);
        }
    }
}
