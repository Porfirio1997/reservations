package com.example.Reservations.mapper;

import com.example.Reservations.dto.LocationDTO;
import com.example.Reservations.model.entity.Location;

public class LocationDTOMapper {
    public Location toDomain(LocationDTO dto) {
        return Location.builder()
                .id(dto.id())
                .nome(dto.nome())
                .tipo(dto.tipo())
                .descricao(dto.descricao())
                .valor_hora(dto.valor_hora())
                .tempo_minimo(dto.tempo_minimo())
                .tempo_maximo(dto.tempo_maximo())
                .build();
    }

    public LocationDTO toResponse(Location location) {
        return new LocationDTO(
                location.getId(),
                location.getNome(),
                location.getTipo(),
                location.getDescricao(),
                location.getValor_hora(),
                location.getTempo_minimo(),
                location.getTempo_maximo()
        );
    }
}
