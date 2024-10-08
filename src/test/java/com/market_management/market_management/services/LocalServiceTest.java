package com.market_management.market_management.services;

import com.market_management.market_management.models.Local;
import com.market_management.market_management.repositories.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalServiceTest {

    @Autowired
    private LocalService localService;

    @MockBean
    private LocalRepository localRepository;

    @BeforeEach
    void setUp() {
        Local local = Local.builder().name("PetShop").floor("3 floor").code("ctd-12-01-2024").build();

        Mockito.when(localRepository.findLocalByNameWithJPQL("PetShop")).thenReturn(List.of(local));
    }

    @Test
    public void findByNameIgnoreCaseShouldFund(){
        String localName = "PetShop";
        Local local = localService.findLocalByNameWithJPQL(localName).get(0);
        assertEquals(localName, local.getName());
        System.out.println("Local = " + local);
    }
}