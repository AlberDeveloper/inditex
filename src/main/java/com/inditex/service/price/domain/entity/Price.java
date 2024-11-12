package com.inditex.service.price.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Class Price entity class to get price information from the database
 *
 * @author Alberto Pereira
 */
@Entity
@Table(name = "PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private int priceList;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private float price;

    @Column(name = "curr")
    private String currency;

    public long getId() {
        return id;
    }

    public int getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public int getProductId() {
        return productId;
    }

    public int getPriority() {
        return priority;
    }

    public float getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}

