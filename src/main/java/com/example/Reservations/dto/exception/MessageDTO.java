package com.example.Reservations.dto.exception;

import lombok.Builder;

@Builder
public record MessageDTO (String message, String key){}
