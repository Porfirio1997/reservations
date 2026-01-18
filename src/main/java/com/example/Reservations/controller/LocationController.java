package com.example.Reservations.controller;

import com.example.Reservations.dto.LocationDTO;
import com.example.Reservations.mapper.LocationDTOMapper;


import com.example.Reservations.service.impl.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final LocationDTOMapper mapper = new LocationDTOMapper();

    @PostMapping
    public String createLocation(@RequestBody LocationDTO LocationDTO){
        locationService.save(LocationDTO);
        return "Locação criada com sucesso,\n id da localização : ";
    }

    @GetMapping("/{id}")
    public LocationDTO getLocation(@PathVariable Long id){
        return mapper.toResponse(locationService.findById(id));
    }

    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
        return "Localização deletada com sucesso";
    }
}
