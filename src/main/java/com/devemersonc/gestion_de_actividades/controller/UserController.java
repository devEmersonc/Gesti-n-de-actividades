package com.devemersonc.gestion_de_actividades.controller;

import com.devemersonc.gestion_de_actividades.dto.RegisterUserDTO;
import com.devemersonc.gestion_de_actividades.dto.UserDTO;
import com.devemersonc.gestion_de_actividades.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUser(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/save-normal-user")
    public ResponseEntity<String> registerNormalUser(@Valid @RequestBody RegisterUserDTO registerUserDTO) {
        userService.registerNormalUser(registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado.");
    }

    @PostMapping("/save-admin-user")
    public ResponseEntity<String> registerAdminUser(@Valid @RequestBody RegisterUserDTO registerUserDTO) {
        userService.registerAdminUser(registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody RegisterUserDTO registerUserDTO, @PathVariable Long id) {
        userService.updateUser(id, registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario actualizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuario eliminado.");
    }
}
