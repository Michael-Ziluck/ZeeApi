package com.ziluck.zeeapi.commands;

/**
 * A class that has something to validate.
 *
 * @param <T> the type being validated
 */
public interface Validatable<T> {
    /**
     * Returns the validator used in validation. For some implementations, this will be the same class.
     *
     * @return the validator used in validation
     */
    Validator<T> getValidator();
}
