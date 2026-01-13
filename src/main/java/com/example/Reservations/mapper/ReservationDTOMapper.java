package com.example.Reservations.mapper;

import com.example.Reservations.dto.LocationDTO;
import com.example.Reservations.dto.ReservationDTO;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;
import com.example.Reservations.model.entity.Reservation;

import java.time.Instant;

public class ReservationDTOMapper {
    public Reservation toDomain(ReservationDTO dto) {
        /*



        */
        return new Reservation();
    }

    public ReservationDTO toResponse(Reservation reservation) {
        return new ReservationDTO(
                reservation.getLocation(),
                reservation.getClient(),
                reservation.getData_inicio(),
                reservation.getData_fim(),
                reservation.getValor_final(),
                reservation.getSituacao()
        );
    }
}
