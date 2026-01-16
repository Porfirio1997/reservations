package com.example.Reservations.service.impl;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.exception.ConflictException;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.mapper.ClientDTOMapper;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    private ClientDTOMapper clientDTOMapper = new ClientDTOMapper();

    public void save(ClientDTO clientDTO) {
        Client client = clientDTOMapper.toDomain(clientDTO);

        Optional.ofNullable(findByCpf(clientDTO.cpf())).ifPresent(d -> {
            throw new ConflictException("Já exite um Cliente cadastrado com esse CPF", "database.Client.Exists");
        });

        Instant now = Instant.now();
        if (client.getCreatedDate() == null) {
            client.setCreatedDate(now);
        }

        repository.save(client);
    }

    public Client findByCpf(String cpf) {
        Client client = repository.findByCpf(cpf);
        return Optional.ofNullable(client).orElseThrow(() -> new NotFoundException("Cliente não encontrado", "database.client.not.found"));
    }

    public void deleteByCpf(String cpf) {
        Client client = repository.findByCpf(cpf);
        repository.delete(client);
    }

}
