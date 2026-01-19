package com.example.Reservations.controller;

import com.example.Reservations.dto.*;
import com.example.Reservations.model.entity.Usuario;
import com.example.Reservations.service.impl.UsuarioService;
import com.example.Reservations.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest login) {
        Usuario user = usuarioService.findByUsername(login.username())
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));

        if (!passwordEncoder.matches(login.password(), user.getPassword())) {
            throw new RuntimeException("Email ou senha inválidos");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/singin")
    public ResponseEntity<String> singin(@RequestBody AuthRequest login) {
        return ResponseEntity.ok(usuarioService.createUser(login));
    }
}
