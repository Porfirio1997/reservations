package com.example.Reservations.dto;

import java.math.BigDecimal;

public record LocationDTO(Long id,
                          String nome,
                          String tipo,
                          String descricao,
                          BigDecimal valor_hora,
                          int tempo_minimo,
                          int tempo_maximo
) {
}
