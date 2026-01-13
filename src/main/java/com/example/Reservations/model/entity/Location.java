package com.example.Reservations.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity(name = "tb_locations")
public class Location {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String tipo;

    private String descricao;

    private double valor_hora;

    private int tempo_minimo;

    private int tempo_maximo;

    @Column(nullable = false)
    private Instant data_criacao;

}
