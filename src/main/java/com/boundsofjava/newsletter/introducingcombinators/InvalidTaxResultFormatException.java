package com.boundsofjava.newsletter.introducingcombinators;

import java.math.BigDecimal;

public class InvalidTaxResultFormatException
        extends RuntimeException {

    private InvalidTaxResultFormatException(String message) {
        super(message);
    }

    public InvalidTaxResultFormatException(BigDecimal amount, String formatted) {
        this("Result of adding tax to amount " + amount + " has incorrect format: " + formatted);
    }
}
