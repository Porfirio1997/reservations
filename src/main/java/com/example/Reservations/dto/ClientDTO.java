package com.example.Reservations.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

public record ClientDTO(@NotNull String nome,
                        @NotNull String cpf,
                        @Email()String email,
                        String telefone) {
}
