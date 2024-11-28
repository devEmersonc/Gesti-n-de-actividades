package com.devemersonc.gestion_de_actividades.dto;

import com.devemersonc.gestion_de_actividades.model.Role;
import jakarta.validation.constraints.*;

import java.util.List;

public class RegisterUserDTO {
    @NotNull(message = "Nombre de usuario no puede ser null.")
    @NotBlank(message = "Nombre de usuario es obligatorio.")
    @Size(min = 5, max = 30, message = "El nombre de usuario debe contener entre 5 a 30 caracteres.")
    private String username;

    @NotNull(message = "La contraseña no puede ser null.")
    @NotBlank(message = "La contraseña es obligatoria.")
    private String password;

    @Email(message = "Ingresa un email válido")
    @NotNull(message = "El email no puede ser null.")
    @NotBlank(message = "El email es obligatorio.")
    private String email;

    @NotNull(message = "Edad no puede ser null.")
    private int age;

    @NotNull(message = "El nombre no puede ser null.")
    @NotBlank(message = "El nombre es obligatorio.")
    private String firstname;

    @NotNull(message = "El apellido no puede ser null.")
    @NotBlank(message = "El apellido es obligatorio.")
    private String lastname;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
