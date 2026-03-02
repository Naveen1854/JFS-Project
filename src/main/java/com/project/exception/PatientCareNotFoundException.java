package com.project.exception;

public class PatientCareNotFoundException extends RuntimeException {
    public PatientCareNotFoundException(String message) {
        super(message);
    }
}