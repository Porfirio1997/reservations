package com.example.Reservations.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity(name = "tb_clients")
public class Client {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    private String email;

    private String telefone;

    @Column(nullable = false)
    private Instant data_criacao;
}
