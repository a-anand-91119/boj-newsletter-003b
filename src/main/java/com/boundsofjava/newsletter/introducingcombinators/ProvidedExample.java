package com.boundsofjava.newsletter.introducingcombinators;

import java.math.BigDecimal;
import java.util.function.Function;

class ProvidedExample {

    void demo() {
        System.out.println("------------------------------------");
        System.out.println("Starting PROVIDED combinator demo...");
        System.out.println("------------------------------------");

        Function<BigDecimal, String> addTaxDecorated =
                Provided.decorate(this::isTaxable, this::addTax);

        String result1 = addTaxDecorated.apply(new BigDecimal("10"));

        System.out.println("Done - Result is " + result1);
        System.out.println();

        String result2 = addTaxDecorated.apply(new BigDecimal("5"));

        System.out.println("Done - Result is " + result2);
        System.out.println();
    }

    private boolean isTaxable(BigDecimal argument) {
        boolean condition = argument.compareTo(BigDecimal.TEN) >= 0; // argument >= 10
        System.out.println("PROVIDED: Argument is " + argument + ", condition is " + condition);
        return condition;
    }

    private String addTax(BigDecimal amount) {
        System.out.println("Adding heavy taxes to poor citizen...");
        return "$" + amount.multiply(new BigDecimal("1.22"));
    }
}
