package com.example.Reservations.mapper;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.model.entity.Client;

public class ClientDTOMapper {

    public Client toDomain(ClientDTO dto) {
        return Client.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .email(dto.email())
                .telefone(dto.telefone())
                .build();
    }

    public ClientDTO toResponse(Client client) {
        return new ClientDTO(client.getNome(), client.getCpf(), client.getEmail(), client.getTelefone());
    }
}
