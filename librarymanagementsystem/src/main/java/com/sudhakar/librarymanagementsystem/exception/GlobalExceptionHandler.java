package com.sudhakar.librarymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateMemberException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDuplicateMemberException(DuplicateMemberException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateBookException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDuplicateBookException(DuplicateMemberException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateAuthorException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDuplicateAuthorException(DuplicateAuthorException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicatePublisherException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDuplicatePublisherException(DuplicatePublisherException message) {
        return new ResponseEntity<>(message.getMessage(), HttpStatus.CONFLICT);
    }
}