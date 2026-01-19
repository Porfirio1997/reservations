package com.example.Reservations.service.impl;

import com.example.Reservations.dto.AuthRequest;
import com.example.Reservations.model.entity.Usuario;
import com.example.Reservations.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public String createUser(AuthRequest obj){
        repository.save(new Usuario(null,obj.username(), passwordEncoder.encode(obj.password()), List.of(new SimpleGrantedAuthority("ROLE_USER")).toString()));
        return obj.username() + " Criado com sucesso";
    }

    public Optional<Usuario> findByUsername(String username){
        return repository.findByUsername(username);
    }
}
