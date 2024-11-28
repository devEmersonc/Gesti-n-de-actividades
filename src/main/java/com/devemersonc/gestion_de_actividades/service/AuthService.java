package com.devemersonc.gestion_de_actividades.service;

import com.devemersonc.gestion_de_actividades.dto.AuthRequest;
import com.devemersonc.gestion_de_actividades.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);
}
