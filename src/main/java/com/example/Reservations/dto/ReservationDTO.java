package com.example.Reservations.dto;

import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;

import java.time.Instant;

public record ReservationDTO(Location location,
                             Client client,
                             Instant data_inicio,
                             Instant data_fim,
                             double valor_final,
                             String situacao
) {
}
