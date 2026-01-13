package com.example.Reservations.mapper;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.model.entity.Client;

public class ClientDTOMapper {

    public Client toDomain(ClientDTO dto) {
    /*
         @NotNull
        private String nome;

        @NotNull
        private String cpf;

        private String email;

        private String telefone;
    */
        return new Client();
    }

    public ClientDTO toResponse(Client client) {
        return new ClientDTO(client.getNome(), client.getCpf(), client.getEmail(), client.getTelefone());
    }
}
