package com.library.api.exception;

public class AuthorNotExistException extends RuntimeException {
    public AuthorNotExistException() {
        super("The Author Does Not Exist.");
    }
}
