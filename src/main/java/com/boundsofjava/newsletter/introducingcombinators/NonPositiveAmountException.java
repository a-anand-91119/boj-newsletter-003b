package com.boundsofjava.newsletter.introducingcombinators;

import java.math.BigDecimal;

public class NonPositiveAmountException
        extends RuntimeException {

    private NonPositiveAmountException(String message) {
        super(message);
    }

    public NonPositiveAmountException(BigDecimal amount) {
        this("Amount to be taxed must be > 0 but was " + amount);
    }
}
