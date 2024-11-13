package com.inditex.service.price.infrastructure.controller;

import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String endpoint = "/api/prices";

    @Test
    public void testGetPrice_Base() throws Exception {
        mockMvc.perform(get(endpoint)
                        .param("date", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void testGetPrice_14JuneAfternoon() throws Exception {
        mockMvc.perform(get(endpoint)
                        .param("date", "2020-06-14T16:30:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void testGetPrice_15JuneMorning() throws Exception {
        mockMvc.perform(get(endpoint)
                        .param("date", "2020-06-15T10:30:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    public void testGetPrice_15JuneAfternoon() throws Exception {
        mockMvc.perform(get(endpoint)
                        .param("date", "2020-06-15T17:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95));
    }

    @Test
    public void testGetPrice_15JuneNight() throws Exception {
        mockMvc.perform(get(endpoint)
                        .param("date", "2020-06-15T22:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95));
    }

    @Test
    public void testGetPrice_NotFound() throws Exception {
        // Configurar la fecha de la prueba
        LocalDateTime date = LocalDateTime.of(2021, 6, 14, 10, 0);

        // Realizar la solicitud y verificar que el estado HTTP es 404 Not Found
        mockMvc.perform(get(endpoint)
                        .param("date", date.toString())
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isNotFound());
    }
}
