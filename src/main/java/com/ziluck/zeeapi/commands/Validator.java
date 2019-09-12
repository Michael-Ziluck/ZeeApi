package com.ziluck.zeeapi.commands;

/**
 * A class capable of validating objects of the given type. Most often used in conjunction with {@link Validatable}.
 *
 * @param <T> the type being validated
 */
public interface Validator<T> {
    /**
     * Checks if the given argument is valid in the current context.
     *
     * @param t the argument to validate
     * @return {@code true} if the argument is valid, {@code false} otherwise
     */
    boolean isValid(T t);
}
