package com.example.Reservations.mapper;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.model.entity.Client;

public final class ClientDTOMapper {

    private ClientDTOMapper() {}

    public static Client toDomain(ClientDTO dto) {
        return Client.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .email(dto.email())
                .telefone(dto.telefone())
                .build();
    }

    public static ClientDTO toResponse(Client client) {
        return new ClientDTO(
                client.getNome(),
                client.getCpf(),
                client.getEmail(),
                client.getTelefone()
        );
    }
}