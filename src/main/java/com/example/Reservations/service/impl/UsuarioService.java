package com.example.Reservations.service.impl;

import com.example.Reservations.model.entity.Usuario;
import com.example.Reservations.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Optional<Usuario> findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
