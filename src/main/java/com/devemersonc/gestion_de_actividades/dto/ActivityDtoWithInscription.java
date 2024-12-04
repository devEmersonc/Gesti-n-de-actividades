package com.devemersonc.gestion_de_actividades.dto;

import com.devemersonc.gestion_de_actividades.model.Inscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityDtoWithInscription {

    private Long id;
    private String name;
    private String description;
    private Date date;
    private String hour;
    private String place;
    private int available_slots;
    private List<InscriptionUserDTO> inscriptions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<InscriptionUserDTO> getInscriptionsUserDto() {
        return inscriptions;
    }

    public void setInscriptionsUserDto(List<InscriptionUserDTO> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
