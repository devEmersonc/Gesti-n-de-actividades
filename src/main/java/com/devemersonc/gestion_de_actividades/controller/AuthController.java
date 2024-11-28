package com.devemersonc.gestion_de_actividades.controller;

import com.devemersonc.gestion_de_actividades.dto.AuthRequest;
import com.devemersonc.gestion_de_actividades.dto.AuthResponse;
import com.devemersonc.gestion_de_actividades.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
