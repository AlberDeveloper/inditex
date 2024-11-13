package com.inditex.service.price.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Exception triggered when no price is found for the given criteria.
 *
 * @author Alberto Pereira
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PriceNotFoundException() {
        super("Price not found for the given criteria.");
    }
}
