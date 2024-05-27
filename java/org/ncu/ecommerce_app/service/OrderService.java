package org.ncu.ecommerce_app.service;

import java.util.List;

import org.ncu.ecommerce_app.entity.Order;



public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}
