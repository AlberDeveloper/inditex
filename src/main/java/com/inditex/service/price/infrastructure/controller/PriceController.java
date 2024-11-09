package com.inditex.service.price.infrastructure.controller;

import com.inditex.service.price.application.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    private final PriceServiceImpl priceService;

    @Autowired
    public PriceController(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    @GetMapping()
    public ResponseEntity<String> getPrice(){
        return ResponseEntity.ok("Hello Inditex!");
    }
}
