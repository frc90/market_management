package com.market_management.market_management.services.impl;

import com.market_management.market_management.models.entities.Order;
import com.market_management.market_management.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class OrderRepositoryImplTest {

    @Autowired
    private OrderRepository orderRepository;
    
    @BeforeEach
    void setUp() {
    }

    @Test
    public void getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        System.out.println("orders = " + orders);
    }

    @Test
    public void findOrderByAmount(){
        Optional<Order> orders = orderRepository.findOrderByAmount(78.1);
        System.out.println("orders = " + orders);
    }
}