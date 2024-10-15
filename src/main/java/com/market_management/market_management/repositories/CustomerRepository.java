package com.market_management.market_management.repositories;

import com.market_management.market_management.models.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
            value = "select * from customer where email = :emailAddress",
            nativeQuery = true
    )
    Optional<Customer> getCustomerFirstNameByEmailAddressNative(@Param("emailAddress") String email);


    @Modifying
    @Transactional
    @Query(
            value = "update customer set first_name = ?1 where email = ?2",
            nativeQuery = true
    )
    void updateCustomerNameByEmail(String name, String email);
}
