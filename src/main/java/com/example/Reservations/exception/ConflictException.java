package com.example.Reservations.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends  GlobalException {

    public ConflictException( String message, String key) {
        super(HttpStatus.CONFLICT, message, key);
    }
}
