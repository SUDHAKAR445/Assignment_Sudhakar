package com.trustrace.assignment.scm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingClass {
    @ExceptionHandler(value = MyNotFoundException.class)
    public ResponseEntity<String> catchException(MyNotFoundException handler)
    {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<String> catchNullPointerException(NullPointerException handler)
    {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
