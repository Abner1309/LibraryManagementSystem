package com.library.api.exception;

import com.library.api.dto.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookAlreadyRegisteredException.class)
    public ResponseEntity<StandardError> bookAlreadyRegistered(BookAlreadyRegisteredException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Book Already Registered", e.getMessage(), request);
    }

    @ExceptionHandler(BookNotExistException.class)
    public ResponseEntity<StandardError> bookNotExist(BookNotExistException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Book Does Not Exist", e.getMessage(), request);
    }

    @ExceptionHandler(AuthorNotExistException.class)
    public ResponseEntity<StandardError> authorNotExist(AuthorNotExistException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Author Does Not Exist", e.getMessage(), request);
    }

    private ResponseEntity<StandardError> buildResponse(HttpStatus status, String error, String message, HttpServletRequest request) {
        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
