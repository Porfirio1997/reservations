package com.example.Reservations.exception;

import com.example.Reservations.dto.exception.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalException  extends RuntimeException{
    private final HttpStatus status;
    private final String key;

    public GlobalException(HttpStatus status, String message,  String key) {
        super(message);
        this.status = status;
        this.key = key;
    }
    public ResponseEntity<MessageDTO> getMessageError() {
        return ResponseEntity
                .status(status)
                .body(MessageDTO
                        .builder()
                        .message(getMessage())
                        .key(key)
                        .build());
    }

}
