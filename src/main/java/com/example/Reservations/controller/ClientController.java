package com.example.Reservations.controller;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.mapper.ClientDTOMapper;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.service.impl.ClientService;
import com.example.Reservations.service.impl.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    ClientDTOMapper clientDTOMapper = new ClientDTOMapper();

    @PostMapping
    public String createClient(@RequestBody ClientDTO clientDTO){
        clientService.save(clientDTO);
        return "Cliente criado com sucesso";
    }

    @GetMapping("/{cpf}")
    public ClientDTO getClient(@PathVariable String cpf){
        var client = clientService.findByCpf(cpf);
        return clientDTOMapper.toResponse(client);
    }

    @DeleteMapping("/{cpf}")
    public String deleteClient(@PathVariable String cpf){
        clientService.deleteByCpf(cpf);
        return "Cliente deletado com sucesso";
    }

}
