package com.example.Reservations.dto.exception;

import lombok.Builder;

@Builder
public record ErrorObjectDTO(String message, String field, Object parameter) {
}
