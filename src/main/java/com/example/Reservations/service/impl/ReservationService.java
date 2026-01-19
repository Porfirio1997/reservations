package com.example.Reservations.service.impl;

import com.example.Reservations.dto.ClientDTO;
import com.example.Reservations.dto.ReservationDTO;
import com.example.Reservations.exception.BusinessException;
import com.example.Reservations.exception.ConflictException;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.mapper.ReservationDTOMapper;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Reservation;
import com.example.Reservations.model.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public void validateLocationCanBeDeleted(Long locationId) {
        if (repository.existsByLocationId(locationId)) {
            throw new BusinessException(
                    "Não é possível excluir a localização pois existem reservas associadas",
                    "business.location.has.reservations"
            );
        }
    }

    public void validateClientCanBeDeleted(Long clientId) {
        if (repository.existsByClientId(clientId)) {
            throw new BusinessException("Não é possivel excluir o cliente pois existem reservas associadas",
                    "business.client.has.reservations");
        }
    }

    public Long save(ReservationDTO dto) {
        Reservation reservation = ReservationDTOMapper.toDomain(dto);

        if (repository.existsByLocationAndDataInicioLessThanAndDataFimGreaterThan(dto.location(),dto.data_fim(),dto.data_inicio()))
            throw new BusinessException("Localização está reservada para a data","business.location.is.reserved");

        return repository.save(reservation).getId();
    }

    public Reservation findById(Long id) {
        Reservation reservation = repository.findById(id).orElseThrow(() -> new NotFoundException("Reserva não encontrada", "database.client.not.found"));;
        return reservation;
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }



}
