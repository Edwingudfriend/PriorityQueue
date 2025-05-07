package com.example.priorityqueue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException {
    
    public PatientNotFoundException() {
        super("Patient not found");
    }

    public PatientNotFoundException(Long id) {
        super("Patient with ID " + id + " not found");
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}