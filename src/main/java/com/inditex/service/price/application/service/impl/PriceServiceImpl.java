package com.inditex.service.price.application.service.impl;

import com.inditex.service.price.application.service.PriceService;
import com.inditex.service.price.domain.entity.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {
    @Override
    public Optional<Price> findPrice(LocalDateTime date, int productId, int brandId) {
        return Optional.empty();
    }
}
