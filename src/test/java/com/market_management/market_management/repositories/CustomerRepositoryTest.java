package com.market_management.market_management.repositories;

import com.market_management.market_management.models.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void findCustomerByFirstName() {
        Customer customer = customerRepository.findCustomerByFirstName("Francisco").get();
        System.out.println("customer = " + customer);
    }

    @Test
    public void findCustomersByFirstNameContains(){
        List<Customer> customers = customerRepository.findCustomersByFirstNameContains("fr");
        System.out.println("customers = " + customers);
    }

    @Test
    public void getCustomerByEmailAddress() {
        Customer customer = customerRepository.getCustomerByEmailAddress("francy@gmail.com").get();
        System.out.println("customer = " + customer);
    }

    @Test
    public void getCustomerFirstNameByEmailAddress() {
        String firstName = customerRepository.getCustomerFirstNameByEmailAddress("francy@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void getCustomerFirstNameByEmailAddressNative() {
        Customer customer = customerRepository.getCustomerFirstNameByEmailAddressNative("francy@gmail.com").get();
        System.out.println("customer = " + customer);
    }
}