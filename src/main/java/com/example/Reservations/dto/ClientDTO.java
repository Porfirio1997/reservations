package com.example.Reservations.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

public record ClientDTO(Long id,
                        @NotNull String nome,
                        @NotNull String cpf,
                        @Email()String email,
                        String telefone) {
}
