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

    // verificar se uma locação está reservada na data
    @Query("""
    select r from Reservation r
    where r.location_id = :location
      and r.dataInicio < :fim
      and r.dataFim > :inicio
    """)
    Boolean findByLocationAndPeriodo(
            @Param("location") Location location,
            @Param("inicio") Instant inicio,
            @Param("fim") Instant fim
    );

    Boolean existsByClientId(Long clientId);
    Boolean existsByLocationId(Long locationId);

}
