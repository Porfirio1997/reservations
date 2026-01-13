package com.example.Reservations.model.repository;

import com.example.Reservations.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {}
