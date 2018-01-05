package com.boundsofjava.newsletter.introducingcombinators;

import java.math.BigDecimal;
import java.util.function.Function;

class PreconditionExample {

    void demo() {
        System.out.println("----------------------------------------");
        System.out.println("Starting PRECONDITION combinator demo...");
        System.out.println("----------------------------------------");

        Function<BigDecimal, String> addTaxDecorated =
                Precondition.decorate(this::isGreaterThanZero, this::addTax, this::invalidAmount);

        String result1 = addTaxDecorated.apply(new BigDecimal("10"));

        System.out.println("Done - Result is " + result1);
        System.out.println("----------------------------------------");

        try {
            String result2 = addTaxDecorated.apply(new BigDecimal("-5"));

            System.out.println("Done - Result is " + result2);
        } catch (InvalidAmountException e) {

            System.out.println("Exception catched: " + e.getMessage());
        }
        System.out.println("----------------------------------------");
    }

    private boolean isGreaterThanZero(BigDecimal argument) {
        boolean condition = argument.compareTo(BigDecimal.ZERO) > 0; // argument > 0
        System.out.println("PRECONDITION: Argument is " + argument + ", condition is " + condition);
        return condition;
    }

    private String addTax(BigDecimal amount) {
        System.out.println("Adding heavy taxes to poor citizen...");
        return "$" + amount.multiply(new BigDecimal("1.22"));
    }

    private InvalidAmountException invalidAmount(BigDecimal amount) {
        System.out.println("INVALID AMOUNT: amount <= 0");
        return new InvalidAmountException("Amount to be taxed must be > 0 and is " + amount);
    }
}
