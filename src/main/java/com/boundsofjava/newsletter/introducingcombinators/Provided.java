package com.boundsofjava.newsletter.introducingcombinators;

import java.util.function.Function;
import java.util.function.Predicate;

// @formatter:off
@FunctionalInterface
public interface Provided<T, R>
        extends Function<Predicate<T>,
                Function<Function<T, R>,
                Function<T, R>>> {
// @formatter:on

    static <T, R> Provided<T, R> create() {
        return condition -> function -> argument ->
            condition.test(argument) ? function.apply(argument) : null;
    }

    static <T, R> Function<T, R> decorate(
            Predicate<T> condition,
            Function<T, R> function) {
        return Provided.<T, R>create().apply(condition).apply(function);
    }
}
