package com.example.Reservations.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity(name = "client")
public class Client extends AbstractEntity{
    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    private String email;

    private String telefone;
}
