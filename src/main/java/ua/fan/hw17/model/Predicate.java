package ua.fan.hw17.model;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
