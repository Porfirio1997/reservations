package com.example.Reservations.dto;

import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;

import java.math.BigDecimal;
import java.time.Instant;

public record ReservationDTO(Long id,
                             Location location,
                             Client client,
                             Instant data_inicio,
                             Instant data_fim,
                             BigDecimal valor_final,
                             String situacao
) {
}
