package com.example.Reservations.model.repository;

import com.example.Reservations.model.entity.Client;
import com.example.Reservations.model.entity.Location;
import com.example.Reservations.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    boolean existsByLocationAndDataInicioLessThanAndDataFimGreaterThan(Location location,Instant fim,Instant inicio);
    Boolean existsByClientId(Long clientId);
    Boolean existsByLocationId(Long locationId);
}
