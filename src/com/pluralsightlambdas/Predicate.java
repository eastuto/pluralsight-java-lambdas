package com.pluralsightlambdas;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        return t -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other) {
        return t -> test(t) || other.test(t);
    }

    static <U> Predicate<U> isEqualTo(U u) {
        return s -> s.equals(u);
    }
}

