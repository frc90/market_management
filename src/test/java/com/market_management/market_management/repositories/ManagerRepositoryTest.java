package com.market_management.market_management.repositories;

import com.market_management.market_management.models.entities.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void getAll(){
        List<Manager> manager = managerRepository.findAll();
        System.out.println("manager = " + manager);
    }
}