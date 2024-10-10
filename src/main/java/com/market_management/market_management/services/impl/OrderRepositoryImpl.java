package com.market_management.market_management.services.impl;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Order;

import java.util.List;

public interface OrderRepositoryImpl {
    List<Order> getAllOrders();
    Order getOrderById(Long id) throws NotFoundException;
    Order saveOrder(Order order);
    Order updateOrder(Long id, Order order);
    String deleteOrder(Long id);
}
