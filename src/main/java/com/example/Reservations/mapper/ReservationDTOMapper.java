package com.example.Reservations.mapper;

import com.example.Reservations.dto.ReservationDTO;
import com.example.Reservations.model.entity.Reservation;

public final class ReservationDTOMapper {

    private ReservationDTOMapper() {  }

    public static Reservation toDomain(ReservationDTO dto) {
        return Reservation.builder()
                .id(dto.id())
                .dataInicio(dto.dataInicio())
                .dataFim(dto.dataFim())
                .valorFinal(dto.valorFinal())
                .situacao(dto.situacao())
                .build();
    }

    public static ReservationDTO toResponse(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getLocation().getId(),
                reservation.getClient().getId(),
                reservation.getDataInicio(),
                reservation.getDataFim(),
                reservation.getValorFinal(),
                reservation.getSituacao()
        );
    }
}
