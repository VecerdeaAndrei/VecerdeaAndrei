package com.example.demo.exception;

public class DuplicateAngajatiException extends RuntimeException {
    public DuplicateAngajatiException() {
       super("User email exists") ;
    }
}
