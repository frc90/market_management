package com.market_management.market_management.repositories;

import com.market_management.market_management.models.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;

    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Local local = Local.builder().name("Burger King").floor("3 floors").code("ctd-12-01-2024").build();
        entityManager.persist(local);
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
}