package com.inditex.service.price.infrastructure.dto;

import java.time.LocalDateTime;

/**
 * Class PriceResponse to get price information from the database
 *
 * @author Alberto Pereira
 */
public class PriceResponse {
    private final int productId;
    private final int brandId;
    private final int priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final float price;

    /**
     *
     * @param productId
     * @param brandId
     * @param priceList
     * @param startDate
     * @param endDate
     * @param price
     */
    public PriceResponse(int productId, int brandId, int priceList, LocalDateTime startDate, LocalDateTime endDate, float price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public int getBrandId() {
        return brandId;
    }

    public int getPriceList() {
        return priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public float getPrice() {
        return price;
    }
}
