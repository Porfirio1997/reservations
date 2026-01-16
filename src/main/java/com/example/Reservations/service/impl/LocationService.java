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
    private LocationDTOMapper locationDTOMapper = new LocationDTOMapper();

    public void save(LocationDTO locationDTO) {
        Location client = locationDTOMapper.toDomain(locationDTO);

        Instant now = Instant.now();
        if (client.getCreatedDate() == null) {
            client.setCreatedDate(now);
        }

        repository.save(client);
    }

    public Location findById(Long id) {
        Optional<Location> location = repository.findById(id);

        if (location.isPresent()) {
            return location.get();
        }

        throw  new NotFoundException("Localização não encontrada", "database.Location.not.found");
    }

    public void deleteById(Long id) {
        Optional<Location> location = repository.findById(id);
        if (location.isPresent())
            repository.deleteById(id);
    }
}
