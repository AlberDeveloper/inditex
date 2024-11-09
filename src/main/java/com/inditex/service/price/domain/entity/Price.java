package com.inditex.service.price.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // TODO
}

