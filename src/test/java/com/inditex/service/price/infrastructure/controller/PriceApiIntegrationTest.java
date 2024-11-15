package com.inditex.service.price.infrastructure.controller;

import com.inditex.service.price.domain.exception.PriceNotFoundException;
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

    private String endpoint = "/v1/api/prices/getPrice";

    /**
     * Verifies that the controller correctly returns a price when a valid request is submitted.
     */
    @Test
    public void testGetPrice_Success() {
            ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(endpoint + "?date=2020-06-14T10:00:00&productId=35455&brandId=1", PriceResponseDto.class);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().getPriceList());
    }

    /**
     * Verifies that the controller correctly returns a 404 Not Found response when an invalid request is submitted.
     */
    @Test
    public void testGetPrice_NotFound() {
        ResponseEntity<PriceNotFoundException> response = restTemplate.getForEntity(endpoint + "?date=2020-06-14T10:00:00&productId=99999&brandId=1", PriceNotFoundException.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Price not found for the given criteria.", response.getBody().getMessage());
    }
}

