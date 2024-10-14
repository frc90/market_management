package com.market_management.market_management.repositories;

import com.market_management.market_management.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByFirstName(String firstName);
    List<Customer> findCustomersByFirstNameContains(String contain);

    @Query("select c from Customer c where c.email = ?1")
    Optional<Customer> getCustomerByEmailAddress(String email);

    @Query("select c.firstName from Customer c where c.email = :email")
    String getCustomerFirstNameByEmailAddress(String email);

    @Query(
            value = "select * from customer where email = ?1",
            nativeQuery = true
    )
    Optional<Customer> getCustomerFirstNameByEmailAddressNative(String email);
}
