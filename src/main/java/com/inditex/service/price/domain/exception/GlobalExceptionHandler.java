package com.inditex.service.price.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the project.
 *
 * @author Alberto Pereira
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles the PriceNotFoundException exception and returns a custom 404 response.
     *
     * @param ex The exception launched.
     * @return ResponseEntity with details of the error.
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handlePriceNotFoundException(PriceNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Not Found");
        problemDetail.setDetail(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }
}
