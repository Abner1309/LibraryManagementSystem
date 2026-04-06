package com.library.api.exception;

public class BookAlreadyRegisteredException extends RuntimeException {
    public BookAlreadyRegisteredException() {
        super("The Book Already Registered.");
    }
}
