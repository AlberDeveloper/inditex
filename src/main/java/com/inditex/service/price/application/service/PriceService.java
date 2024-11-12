package com.inditex.service.price.application.service;

import com.inditex.service.price.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The PriceService interface defines the methods for finding a price for a given product and brand at a specific date.
 *
 * @author Alberto Pereira
 */
public interface PriceService {
    /**
     * Finds a price for a given product and brand at a specific date.
     *
     * @param date the date for which the price is requested
     * @param productId the ID of the product
     * @param brandId the ID of the brand
     * @return an Optional containing the Price if found, or an empty Optional if no price is available
     */
    Optional<Price> findPrice(LocalDateTime date, int productId, int brandId);
}
