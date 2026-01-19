package com.example.Reservations.service.impl;

import com.example.Reservations.dto.LocationDTO;
import com.example.Reservations.exception.BusinessException;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.mapper.LocationDTOMapper;
import com.example.Reservations.model.entity.Location;
import com.example.Reservations.model.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LocationService {
    private final LocationRepository repository;
    private final ClientLocationReservationService domainService;

    public void save(LocationDTO locationDTO) {
        Location location = LocationDTOMapper.toDomain(locationDTO);
        //location.setCreatedDate(Instant.now());
        repository.save(location);
    }

    public Location findById(Long id) {
        Location location = repository.findById(id).orElseThrow(() -> new NotFoundException("Localização não encontrada", "database.Location.not.found"));;
        return location;
    }

    public List<LocationDTO> getAllLocations() {
        return repository.findAll()
                .stream()
                .map(LocationDTOMapper::toResponse)
                .toList();
    }

    public void deleteById(Long id) {
        domainService.validateLocationCanBeDeleted(id);
        Optional<Location> location = repository.findById(id);

        if (location.isPresent())
            repository.deleteById(id);
    }

    public List<LocationDTO> getAvailableLocations(Instant data) {
        // Pega todas as localidades
        List<Location> allLocations = repository.findAll();

        // Filtra apenas as disponíveis
        List<Location> availableLocations = allLocations.stream()
                .filter(location ->
                        !domainService.existsByLocationAndDataInicioLessThanAndDataFimGreaterThan(location, data)
                )
                .toList();

        // Converte para DTO
        return availableLocations.stream()
                .map(LocationDTOMapper::toResponse)
                .toList();
    }
}
