package com.sudhakar.librarymanagementsystem.exception;

public class DuplicateAuthorException extends RuntimeException {
    public DuplicateAuthorException(String message){
        super(message);
    }
}
