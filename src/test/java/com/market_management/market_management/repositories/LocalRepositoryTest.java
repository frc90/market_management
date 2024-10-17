package com.market_management.market_management.repositories;

import com.market_management.market_management.models.entities.Local;
import com.market_management.market_management.models.entities.Manager;
import com.market_management.market_management.models.entities.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
//        Local local = Local.builder().name("Burger King").floor("3 floors").code("ctd-12-01-2024").build();
//        entityManager.persist(local);
    }

    @Test
    @DisplayName("Get local name with valid name")
    public void findLocalByNameIgnoreCaseFound(){
        List<Local> local = localRepository.findLocalByNameWithJPQL("Burger King");
        assertEquals(local.get(0).getName(), "Burger King");
    }

    @Test
    @DisplayName("Local name not found")
    public void findLocalByNameIgnoreCaseNotFound(){
        List<Local> local = localRepository.findLocalByNameWithJPQL("Burger");
        assertEquals(local, new ArrayList<Local>());
    }

    @Test
    @DisplayName("Create Local with Manager")
    public void createLocalWithManager(){
        Manager manager = Manager.builder()
                .firstName("Pablo")
                .lastName("Perez")
                .build();

        Local local = Local.builder()
                .code("ctd-10-15-2024")
                .floor("floor 3")
                .name("local 2")
                .manager(manager)
                .build();
        localRepository.save(local);
    }

    @Test
    public void getAll(){
        localRepository.findAll();
    }

    @Test
    public void saveLocalWithOrders(){
        Manager manager = Manager.builder()
                .firstName("Pedro")
                .lastName("Gonzalez")
                .build();
        managerRepository.save(manager);
        Local local = Local.builder()
                .name("Italian Restaurant")
                .floor("floor 3")
                .name("local 3")
                .manager(manager)
                .build();
        localRepository.save(local);
        Order order = Order.builder()
                .amount(50.54)
                .description("Testing 1")
                .local(local)
                .build();
        orderRepository.save(order);

    }
}