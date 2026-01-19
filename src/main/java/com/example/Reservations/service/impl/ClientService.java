package com.example.Reservations.service.impl;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.exception.ConflictException;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.mapper.ClientDTOMapper;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repository;
    private final ClientLocationReservationService domainService;

    public void save(ClientDTO clientDTO) {
        Client client = ClientDTOMapper.toDomain(clientDTO);

        if (repository.existsByCpf(clientDTO.cpf())) {
            throw new ConflictException(
                    "Já existe um Cliente cadastrado com esse CPF",
                    "database.client.exists"
            );
        }

        //client.setCreatedDate(Instant.now());
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
        domainService.validateClientCanBeDeleted(id);
        repository.deleteById(id);
    }

    public void deleteByCpf(String cpf) {
        Client client = repository.findByCpf(cpf);
        Optional.ofNullable(client).orElseThrow(() -> new NotFoundException("Cliente não encontrado para exclusão", "database.client.not.found"));
        domainService.validateClientCanBeDeleted(client.getId());
        repository.delete(client);
    }

    public List<ClientDTO> getAllClients() {
        return repository.findAll()
                .stream()
                .map(ClientDTOMapper::toResponse)
                .toList();
    }
}
