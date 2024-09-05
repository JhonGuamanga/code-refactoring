package com.appgate.dtp.code.refactoring.domain.analyzesocialmention.exceptions;

public class InvalidUrlException extends RuntimeException {

    public static final String MESSAGE = "The URL '%s' is invalid";

    public InvalidUrlException(String value) {
        super(String.format(MESSAGE, value));
    }
}
