package com.library.api.exception;

public class BookNotExistException extends RuntimeException {
    public BookNotExistException(String message) {
        super(message);
    }
}
