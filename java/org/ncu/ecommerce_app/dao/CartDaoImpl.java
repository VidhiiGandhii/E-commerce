package org.ncu.ecommerce_app.dao;

import java.util.List;

import org.ncu.ecommerce_app.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class CartDaoImpl implements CartDao  {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	@Override
    public List<Cart> findAll() {
        String hql = "FROM Cart as c ORDER BY c.id";
        return (List<Cart>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Cart findById(Long id) {
        return entityManager.find(Cart.class, id);
    }

    @Override
    public Cart save(Cart cart) {
        entityManager.persist(cart);
        return cart;
    }

    @Override
    public void deleteById(Long id) {
        Cart cart = findById(id);
        if (cart != null) {
            entityManager.remove(cart);
        }
    }
}
