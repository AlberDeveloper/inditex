package com.inditex.service.price.application.service.impl;

import com.inditex.service.price.application.service.PriceService;
import com.inditex.service.price.domain.entity.Price;
import com.inditex.service.price.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * Implementation of the PriceService interface.
 *
 * @author Alberto Pereira
 */

@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Finds the applicable price for a given product and brand at a specific date.
     * The method queries the price repository to retrieve a list of prices
     * within the specified date range, ordered by priority in descending order.
     * Returns the first price in the list if available.
     *
     * @param date the date for which the price is requested
     * @param productId the ID of the product
     * @param brandId the ID of the brand
     * @return an Optional containing the Price if found, or an empty Optional if no price is available
     */
    @Override
    public Optional<Price> findPrice(LocalDateTime date, int productId, int brandId) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, date, date);

        return prices.stream().findFirst();
    }
}
