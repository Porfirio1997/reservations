package com.example.Reservations.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record LocationDTO(Long id,
                          String nome,
                          String tipo,
                          String descricao,
                          BigDecimal valor_hora,
                          Instant tempo_minimo,
                          Instant tempo_maximo
) {}
