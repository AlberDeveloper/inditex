package com.inditex.service.price.application.service;

import com.inditex.service.price.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {
    Optional<Price> findPrice(LocalDateTime date, int productId, int brandId);
}
