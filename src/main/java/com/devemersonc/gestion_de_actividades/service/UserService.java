package com.devemersonc.gestion_de_actividades.service;

import com.devemersonc.gestion_de_actividades.dto.RegisterUserDTO;
import com.devemersonc.gestion_de_actividades.dto.UserDTO;
import com.devemersonc.gestion_de_actividades.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUser(Long id);
    void registerNormalUser(RegisterUserDTO registerUserDTO);
    void registerAdminUser(RegisterUserDTO registerUserDTO);
    void updateUser(Long id, RegisterUserDTO registerUserDTO);
    void deleteUser(Long id);
    UserDTO convertEntityToDto(User user);
}
