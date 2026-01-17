package com.example.Reservations.service.impl;

import com.example.Reservations.exception.BusinessException;
import com.example.Reservations.model.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LocationService locationService;
    @Autowired
    private ClientService clientService;

    public void validateLocationCanBeDeleted(Long locationId) {
        locationService.findById(locationId);
        if (reservationRepository.existsByLocationId(locationId)) {
            throw new BusinessException(
                    "Não é possível excluir a localização pois existem reservas associadas",
                    "business.location.has.reservations"
            );
        }
    }

    public void validateClientCanBeDeleted(Long clientId) {
        clientService.findById(clientId);
        if (reservationRepository.existsByClientId(clientId)) {
            throw new BusinessException("Não é possivel excluir o cliente pois existem reservas associadas",
                    "business.client.has.reservations");
        }
    }
}
