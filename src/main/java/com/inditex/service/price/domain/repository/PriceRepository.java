package com.inditex.service.price.domain.repository;

import com.inditex.service.price.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository for the Price entity.
 *
 * @author Alberto Pereira
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    /**
     * Finds all prices for a given product and brand, valid for a given date,
     * ordered by priority in descending order.
     *
     * @param productId the ID of the product
     * @param brandId the ID of the brand
     * @param startDate the start date of the price validity period
     * @param endDate the end date of the price validity period
     * @return a list of prices, ordered by priority in descending order
     */
    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            int productId, int brandId, LocalDateTime startDate, LocalDateTime endDate);
}
