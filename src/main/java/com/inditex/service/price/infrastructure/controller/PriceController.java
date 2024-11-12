package com.inditex.service.price.infrastructure.controller;

import com.inditex.service.price.application.service.impl.PriceServiceImpl;
import com.inditex.service.price.domain.entity.Price;
import com.inditex.service.price.infrastructure.dto.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * The PriceController class is a Spring REST controller that handles requests for prices.
 * It uses the PriceService class to retrieve the price for a given product and brand at a specific date.
 *
 * @author Alberto Pereira
 */
@RestController
@RequestMapping("/api/prices")
public class PriceController {
    private final PriceServiceImpl priceService;

    @Autowired
    public PriceController(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }


    /**
     * Retrieves the price for a specified product and brand at a given date.
     *
     * @param date the date for which the price is requested
     * @param productId the ID of the product
     * @param brandId the ID of the brand
     * @return a ResponseEntity containing the PriceResponse if found
     * @throws Exception if no price is available for the given parameters
     */
    @GetMapping()
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam("date") LocalDateTime date,
            @RequestParam("productId") int productId,
            @RequestParam("brandId") int brandId) throws Exception {

        Price price = priceService.findPrice(date, productId, brandId)
                .orElseThrow(Exception::new);

        PriceResponse priceResponse = new PriceResponse(price.getProductId(), price.getBrandId(), price.getPriceList(),
                price.getStartDate(), price.getEndDate(), price.getPrice());

        return ResponseEntity.ok(priceResponse);
    }
}
