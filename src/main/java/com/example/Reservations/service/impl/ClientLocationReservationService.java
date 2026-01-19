package com.example.Reservations.service.impl;

import com.example.Reservations.exception.BusinessException;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;
import com.example.Reservations.model.repository.ClientRepository;
import com.example.Reservations.model.repository.LocationRepository;
import com.example.Reservations.model.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ClientLocationReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final LocationRepository locationRepository;

    public void validateLocationCanBeDeleted(Long locationId) {
        if (reservationRepository.existsByLocationId(locationId)) {
            throw new BusinessException(
                    "Não é possível excluir a localização pois existem reservas associadas",
                    "business.location.has.reservations"
            );
        }
    }

    public void validateClientCanBeDeleted(Long clientId) {
        if (reservationRepository.existsByClientId(clientId)) {
            throw new BusinessException("Não é possivel excluir o cliente pois existem reservas associadas",
                    "business.client.has.reservations");
        }
    }

    public Client findClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado", "database.client.not.found"));;
        return client;
    }

    public Location findLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Localização não encontrada", "database.Location.not.found"));;
        return location;
    }

    public boolean existsByLocationAndDataInicioLessThanAndDataFimGreaterThan(Location location, Instant data){
        return reservationRepository.existsByLocationAndDataInicioLessThanAndDataFimGreaterThan(location,data,data);
    }
}
