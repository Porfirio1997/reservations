package com.example.Reservations.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity(name = "location")
public class Location  extends AbstractEntity{
    private String nome;

    private String tipo;

    private String descricao;

    private BigDecimal valor_hora;

    private int tempo_minimo;

    private int tempo_maximo;

}
