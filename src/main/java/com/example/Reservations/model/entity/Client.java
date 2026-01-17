package com.example.Reservations.model.entity;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "client")
public class Client extends AbstractEntity{

    private String nome;

    private String cpf;

    private String email;

    private String telefone;
}
