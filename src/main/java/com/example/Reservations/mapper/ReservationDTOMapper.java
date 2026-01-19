package com.example.Reservations.mapper;

import com.example.Reservations.dto.ReservationDTO;
import com.example.Reservations.model.entity.Reservation;

public final class ReservationDTOMapper {

    private ReservationDTOMapper() {  }

    public static Reservation toDomain(ReservationDTO dto) {
        return Reservation.builder()
                .id(dto.id())
                .location(dto.location())
                .client(dto.client())
                .dataInicio(dto.data_inicio())
                .dataFim(dto.data_fim())
                .valorFinal(dto.valor_final())
                .situacao(dto.situacao())
                .build();
    }

    public static ReservationDTO toResponse(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getLocation(),
                reservation.getClient(),
                reservation.getDataInicio(),
                reservation.getDataFim(),
                reservation.getValorFinal(),
                reservation.getSituacao()
        );
    }
}
