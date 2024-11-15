package com.inditex.service.price.infrastructure.dto;

import java.time.LocalDateTime;

/**
 * Class PriceResponseDto is a data transfer object (DTO) for representing a price response.
 * It contains this information: productId, brandId, priceList, start date, end date, and applied price.
 *
 * @author Alberto Pereira
 */

public class PriceResponseDto {
    private final int productId;
    private final int brandId;
    private final int priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final float price;


    public PriceResponseDto(int productId, int brandId, int priceList, LocalDateTime startDate, LocalDateTime endDate, float price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    private PriceResponseDto(Builder builder) {
        this.productId = builder.productId;
        this.brandId = builder.brandId;
        this.priceList = builder.priceList;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.price = builder.price;
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

    public static class Builder {
        private int productId;
        private int brandId;
        private int priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private float price;

        public Builder productId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder brandId(int brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder priceList(int priceList) {
            this.priceList = priceList;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }

        public PriceResponseDto build() {
            return new PriceResponseDto(this);
        }
    }
}
