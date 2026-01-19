package com.example.Reservations.service.impl;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.exception.ConflictException;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.mapper.ClientDTOMapper;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;
import com.example.Reservations.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ReservationService reservationService;

    public void save(ClientDTO clientDTO) {
        Client client = ClientDTOMapper.toDomain(clientDTO);

        Optional.ofNullable(findByCpf(clientDTO.cpf())).ifPresent(d -> {
            throw new ConflictException("Já exite um Cliente cadastrado com esse CPF", "database.Client.Exists");
        });

        repository.save(client);
    }

    public Client findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado", "database.client.not.found"));;
        return client;
    }

    public Client findByCpf(String cpf) {
        Client client = repository.findByCpf(cpf);
        return Optional.ofNullable(client).orElseThrow(() -> new NotFoundException("Cliente não encontrado", "database.client.not.found"));
    }

    public void deleteById(long id) {
        reservationService.validateClientCanBeDeleted(id);
        repository.deleteById(id);
    }

    public void deleteByCpf(String cpf) {
        Client client = repository.findByCpf(cpf);

        Optional.ofNullable(client).orElseThrow(() -> new NotFoundException("Cliente não encontrado para exclusão", "database.client.not.found"));

        reservationService.validateClientCanBeDeleted(client.getId());

        repository.delete(client);
    }

}
