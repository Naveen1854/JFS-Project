package com.project.exception;

public class PrescriptionNotFoundException extends RuntimeException {
    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}
