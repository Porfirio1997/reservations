package com.example.Reservations.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "location")
public class Location  extends AbstractEntity{

    private Long id;

    private String nome;

    private String tipo;

    private String descricao;

    private BigDecimal valor_hora;

    private Instant tempo_minimo;

    private Instant tempo_maximo;

}
