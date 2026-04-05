package com.library.api.exception;

public class BookAlreadyRegisteredException extends RuntimeException {
    public BookAlreadyRegisteredException(String message) {
        super(message);
    }
}
