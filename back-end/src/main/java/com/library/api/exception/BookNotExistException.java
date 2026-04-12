package com.library.api.exception;

public class BookNotExistException extends RuntimeException {
    public BookNotExistException() {
        super("The Book Does Not Exist.");
    }
}
