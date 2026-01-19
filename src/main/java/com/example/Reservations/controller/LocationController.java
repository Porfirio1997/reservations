package com.example.Reservations.controller;

import com.example.Reservations.dto.LocationDTO;
import com.example.Reservations.mapper.LocationDTOMapper;


import com.example.Reservations.service.impl.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService service;

    @PostMapping
    public String createLocation(@RequestBody LocationDTO LocationDTO){
        service.save(LocationDTO);
        return "Locação criada com sucesso";
    }

    @GetMapping
    public List<LocationDTO> getAllLocations(){
        return service.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationDTO getLocation(@PathVariable Long id){
        return LocationDTOMapper.toResponse(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable Long id){
        service.deleteById(id);
        return "Localização deletada com sucesso";
    }
    }
