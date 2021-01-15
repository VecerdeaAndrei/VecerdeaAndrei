package com.example.demo.exception;

public class DuplicateClientiException extends RuntimeException {
    public DuplicateClientiException() {
        super("User email exists") ;
    }
}
