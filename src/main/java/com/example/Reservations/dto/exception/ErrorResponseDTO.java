package com.example.Reservations.dto.exception;


import lombok.Builder;

import java.util.List;
@Builder
public record ErrorResponseDTO(String message, String key, String objectName, List<ErrorObjectDTO> errors) {
}
