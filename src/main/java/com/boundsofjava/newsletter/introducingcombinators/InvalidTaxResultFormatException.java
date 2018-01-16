package com.boundsofjava.newsletter.introducingcombinators;

import java.math.BigDecimal;

public class InvalidTaxResultFormatException
        extends RuntimeException {

    private InvalidTaxResultFormatException(String message) {
        super(message);
    }

    public InvalidTaxResultFormatException(BigDecimal amount, String formatted) {
        this("Amount to be taxed must be > 0 but was " + amount);
    }
}
