package com.market_management.market_management.repositories;

import com.market_management.market_management.models.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {

    }

    @Test
    public void saveCustomer() {
        Customer customer = Customer.builder()
                .firstName("Francisco")
                .lastName("Padron")
                .email("francisco@gmail.com")
                .build();

        customerRepository.save(customer);
    }
}