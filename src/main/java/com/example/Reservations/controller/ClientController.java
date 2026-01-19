package com.example.Reservations.controller;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.mapper.ClientDTOMapper;
import com.example.Reservations.service.impl.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public String createClient(@RequestBody ClientDTO clientDTO){
        service.save(clientDTO);
        return "Cliente criado com sucesso";
    }

    @GetMapping
    public List<ClientDTO> getAllClients(){
        return service.getAllClients();
    }

    @GetMapping("/cpf/{cpf}")
    public ClientDTO getClientCpf(@PathVariable String cpf){
        var client = service.findByCpf(cpf);
        return ClientDTOMapper.toResponse(client);
    }

    @DeleteMapping("/cpf/{cpf}")
    public String deleteClientByCpf(@PathVariable String cpf){
        service.deleteByCpf(cpf);
        return "Cliente deletado com sucesso";
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id){
        var client = service.findById(id);
        return ClientDTOMapper.toResponse(client);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id){
        service.deleteById(id);
        return "Cliente deletado com sucesso";
    }
}
