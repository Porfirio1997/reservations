package com.example.Reservations.model.repository;

import com.example.Reservations.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository  extends JpaRepository<Location,Long> {}
