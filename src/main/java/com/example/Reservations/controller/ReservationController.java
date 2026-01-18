package com.example.Reservations.controller;

import com.example.Reservations.dto.ReservationDTO;
import com.example.Reservations.mapper.ReservationDTOMapper;
import com.example.Reservations.service.impl.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    ReservationService service;
    ReservationDTOMapper mapper;

    @PostMapping("/")
    public String createReservation(@RequestBody ReservationDTO dto) {
        Long id = service.save(dto);
        return "Reservado com sucesso,\n id da reserva: " + id;
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservation(@PathVariable Long id){
        return mapper.toResponse(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public String deleteReservation(@PathVariable Long id){
        service.deleteById(id);
        return "Reserva excluida com sucesso";
    }

}
