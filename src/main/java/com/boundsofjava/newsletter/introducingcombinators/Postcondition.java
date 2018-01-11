package com.boundsofjava.newsletter.introducingcombinators;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

// @formatter:off
@FunctionalInterface
public interface Postcondition<T, R, X extends RuntimeException>
        extends Function<Function<T, R>,
                Function<BiPredicate<T, R>,
                Function<BiFunction<T, R, X>,
                Function<T, R>>>> {
// @formatter:on

    static <T, R, X extends RuntimeException> Postcondition<T, R, X> create() {
        return function -> condition -> error -> After.decorate(
                function,
                (arg, res) -> {
                    if (!condition.test(arg, res)) {
                        throw error.apply(arg, res);
                    }
                });
    }

    static <T, R, X extends RuntimeException> Function<T, R> decorate(
            Function<T, R> function,
            BiPredicate<T, R> condition,
            BiFunction<T, R, X> error) {
        return Postcondition.<T, R, X>create().apply(function).apply(condition).apply(error);
    }
}
