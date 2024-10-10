package com.market_management.market_management.services;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Order;
import com.market_management.market_management.repositories.OrderRepository;
import com.market_management.market_management.services.impl.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService implements OrderRepositoryImpl {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) throws NotFoundException {
        Order ord = orderRepository.findById(id).orElse(null);
        if (ord == null) {
            throw new NotFoundException("Order not found");
        }
        return ord;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order ord = orderRepository.findById(id).orElse(null);
        if (ord == null) {
            return null;
        }
        if (Objects.nonNull(order.getDescription()) && !"".equalsIgnoreCase(order.getDescription())) {
            ord.setDescription(order.getDescription());
        }

        if (Objects.nonNull(order.getAmount())) {
            ord.setAmount(order.getAmount());
        }
        return ord;
    }

    @Override
    public String deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return "Order was removed!";
    }
}
