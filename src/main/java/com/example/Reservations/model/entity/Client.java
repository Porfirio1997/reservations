package com.example.Reservations.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "client")
public class Client extends AbstractEntity{
    private Long id;

    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;

    private String telefone;
}
