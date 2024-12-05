package com.devemersonc.gestion_de_actividades.dto;

import com.devemersonc.gestion_de_actividades.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.util.Date;

public class RegisterActivityDTO {
    @NotNull(message = "El nombre no puede ser null.")
    @NotBlank(message = "El nombre es obligatorio.")
    private String name;
    @NotNull(message = "La descripción no puede ser null.")
    @NotBlank(message = "La descripción es obligatoria.")
    private String description;
    @NotNull(message = "La fecha no puede ser null.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @NotNull(message = "La hora no puede ser null.")
    @NotBlank(message = "La hora es obligatoria.")
    private String hour;
    @NotNull(message = "El lugar no puede ser null.")
    @NotBlank(message = "El lugar es obligatorio.")
    private String place;
    @NotNull(message = "Los cupos disponibles no pueden ser null.")
    @Min(value = 0, message = "El mínimo de cupos es 0.")
    @Max(value = 200, message = "El máximo de cupos es 200.")
    private int available_slots;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAvailable_slots() {
        return available_slots;
    }

    public void setAvailable_slots(int available_slots) {
        this.available_slots = available_slots;
    }
}

