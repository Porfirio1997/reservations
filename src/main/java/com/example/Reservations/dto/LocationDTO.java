package com.example.Reservations.dto;

public record LocationDTO(String nome,
                          String tipo,
                          String descricao,
                          double valor_hora,
                          int tempo_minimo,
                          int tempo_maximo
) {
}
