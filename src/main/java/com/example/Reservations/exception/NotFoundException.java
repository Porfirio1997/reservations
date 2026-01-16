package com.example.Reservations.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GlobalException{
    public NotFoundException(String message, String key) {
        super(HttpStatus.NOT_FOUND, message, key);
    }
}

