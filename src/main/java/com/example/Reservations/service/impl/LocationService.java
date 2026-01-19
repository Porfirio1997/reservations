package com.example.Reservations.service.impl;

import com.example.Reservations.dto.LocationDTO;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.mapper.LocationDTOMapper;
import com.example.Reservations.model.entity.Location;
import com.example.Reservations.model.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;
    @Autowired
    private ReservationService reservationService;

    public void save(LocationDTO locationDTO) {
        Location client = LocationDTOMapper.toDomain(locationDTO);

        repository.save(client);
    }

    public Location findById(Long id) {
        Location location = repository.findById(id).orElseThrow(() -> new NotFoundException("Localização não encontrada", "database.Location.not.found"));;
        return location;
    }

    public void deleteById(Long id) {
        reservationService.validateLocationCanBeDeleted(id);
        Optional<Location> location = repository.findById(id);

        if (location.isPresent())
            repository.deleteById(id);
    }
}
