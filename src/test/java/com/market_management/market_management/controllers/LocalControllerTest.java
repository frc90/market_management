package com.market_management.market_management.controllers;

import com.market_management.market_management.models.Local;
import com.market_management.market_management.services.LocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = LocalController.class)
class LocalControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private LocalService localService;

    private Local local;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        local = Local.builder().name("Burger King").floor("3 floors").code("ctd-12-01-2024").build();
    }

    @Test
    public void saveLocal() throws Exception {
        Local postLocal = Local.builder().name("Burger King").floor("3 floors").code("ctd-12-01-2024").build();
        Mockito.when(localService.create(postLocal)).thenReturn(local);
        mockMvc.perform(post("/local").contentType(MediaType.APPLICATION_JSON).content(
                "{\n" +
                        "    \"name\":\"Burger King\",\n" +
                        "    \"floor\":\"3 floor\",\n" +
                        "    \"code\":\"ctd-12-01-2024\"\n" +
                "}"
        )).andExpect(status().isOk());
    }
}