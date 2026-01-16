package com.example.Reservations.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@Entity(name = "client")
public class Client extends AbstractEntity{

    private String nome;

    private String cpf;

    private String email;

    private String telefone;
}
