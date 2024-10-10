package com.market_management.market_management.controllers;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Order;
import com.market_management.market_management.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Long id) throws NotFoundException {
        return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }
}
