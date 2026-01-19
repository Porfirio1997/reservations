package com.example.Reservations.dto;

import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;

import java.math.BigDecimal;
import java.time.Instant;

public record ReservationDTO(Long id,
                             Long locationId,
                             Long clientId,
                             Instant dataInicio,
                             Instant dataFim,
                             BigDecimal valorFinal,
                             String situacao
) {
}
