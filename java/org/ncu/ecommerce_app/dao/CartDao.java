package org.ncu.ecommerce_app.dao;

import java.util.List;

import org.ncu.ecommerce_app.entity.Cart;

public interface CartDao {
	List<Cart> findAll();
    Cart findById(Long id);
    Cart save(Cart cart);
    void deleteById(Long id);

}
