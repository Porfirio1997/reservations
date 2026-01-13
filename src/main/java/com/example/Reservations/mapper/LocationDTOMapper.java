package com.example.Reservations.mapper;

import com.example.Reservations.dto.LocationDTO;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;

public class LocationDTOMapper {
    public Location toDomain(LocationDTO dto) {
        /*
            private String nome;

            private String tipo;

            private String descricao;

            private double valor_hora;

            private int tempo_minimo;

            private int tempo_maximo;
        */
        return new Location();
    }

    public LocationDTO toResponse(Location location) {
        return new LocationDTO(
                location.getNome(),
                location.getTipo(),
                location.getDescricao(),
                location.getValor_hora(),
                location.getTempo_minimo(),
                location.getTempo_maximo()
        );
    }
}
