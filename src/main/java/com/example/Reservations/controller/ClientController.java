package com.example.Reservations.controller;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.mapper.ClientDTOMapper;
import com.example.Reservations.service.impl.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    ClientDTOMapper clientDTOMapper = new ClientDTOMapper();

    @PostMapping
    public String createClient(@RequestBody ClientDTO clientDTO){
        clientService.save(clientDTO);
        return "Cliente criado com sucesso";
    }

    @GetMapping("/cpf/{cpf}")
    public ClientDTO getClientCpf(@PathVariable String cpf){
        var client = clientService.findByCpf(cpf);
        return clientDTOMapper.toResponse(client);
    }

    @DeleteMapping("/cpf/{cpf}")
    public String deleteClientByCpf(@PathVariable String cpf){
        clientService.deleteByCpf(cpf);
        return "Cliente deletado com sucesso";
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id){
        var client = clientService.findById(id);
        return clientDTOMapper.toResponse(client);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id){
        clientService.deleteById(id);
        return "Cliente deletado com sucesso";
    }
}
