package com.example.Reservations.model.repository;

import com.example.Reservations.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByCpf(String CPF);
    boolean existsByCpf(String cpf);
}
