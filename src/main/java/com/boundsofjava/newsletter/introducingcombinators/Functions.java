package com.boundsofjava.newsletter.introducingcombinators;

import java.util.function.Function;

public final class Functions {

    private Functions() {
    }

    public static <T, R> Function<T, R> throwing(Function<? super T, ? extends RuntimeException> error) {
        return argument -> {
            throw error.apply(argument);
        };
    }
}
