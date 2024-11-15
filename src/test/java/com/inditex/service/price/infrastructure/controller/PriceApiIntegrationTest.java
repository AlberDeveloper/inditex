package com.inditex.service.price.infrastructure.controller;

import com.inditex.service.price.infrastructure.dto.PriceResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceApiIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetPrice_Success() {
        try {
            ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("/api/prices?date=2020-06-14T10:00:00&productId=35455&brandId=1", PriceResponseDto.class);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().getPriceList());
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}

