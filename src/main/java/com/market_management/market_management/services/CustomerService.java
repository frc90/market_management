package com.market_management.market_management.services;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Address;
import com.market_management.market_management.models.entities.Customer;
import com.market_management.market_management.repositories.CustomerRepository;
import com.market_management.market_management.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService implements CustomerServiceImpl {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer cu = customerRepository.findById(id).orElse(null);
        if (cu == null){
            return null;
        }
        if (Objects.nonNull(customer.getFirstName()) && !"".equalsIgnoreCase(customer.getFirstName())) {
            cu.setFirstName(customer.getFirstName());
        }

        if (Objects.nonNull(customer.getLastName()) && !"".equalsIgnoreCase(customer.getLastName())) {
            cu.setLastName(customer.getLastName());
        }

        if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
            cu.setEmail(customer.getEmail());
        }
        Address ad = new Address(cu.getAddress().getCity(), cu.getAddress().getMainStreet(), cu.getAddress().getSecondaryStreet());
        cu.setAddress(ad);
        customerRepository.save(cu);
        return cu;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) throws NotFoundException {
        Customer cu = customerRepository.findById(id).orElse(null);
        if (cu == null) {
            throw new NotFoundException("Customer is not available");
        }
        return cu;

    }

    @Override
    public String deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return "Customer with id " + id + " deleted";
    }
}
