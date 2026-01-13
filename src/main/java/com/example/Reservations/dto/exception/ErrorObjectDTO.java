package com.example.Reservations.dto.exception;

public record ErrorObjectDTO(String message, String field, Object parameter) {
}
