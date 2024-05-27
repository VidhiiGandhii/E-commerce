package org.ncu.ecommerce_app.dao;

import org.ncu.ecommerce_app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
    // You can add custom query methods here if needed
}
