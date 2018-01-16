package com.boundsofjava.newsletter.introducingcombinators;

import java.math.BigDecimal;

public class NonPositiveAmountTaxException
        extends RuntimeException {

    private NonPositiveAmountTaxException(String message) {
        super(message);
    }

    public NonPositiveAmountTaxException(BigDecimal amount) {
        this("Amount to be taxed must be > 0 but was " + amount);
    }
}
