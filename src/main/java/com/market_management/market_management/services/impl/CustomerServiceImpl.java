package com.market_management.market_management.services.impl;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Customer;

import java.util.List;

public interface CustomerServiceImpl {
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    Customer getCustomerById(Long id) throws NotFoundException;
    String deleteCustomer(Long id);
}
