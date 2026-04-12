package com.library.api.exception;

public class AuthorAlreadyExistException extends RuntimeException {
    public AuthorAlreadyExistException() {
        super("Author already exists");
    }
}
