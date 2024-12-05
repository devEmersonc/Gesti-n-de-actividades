package com.devemersonc.gestion_de_actividades.dto;

import com.devemersonc.gestion_de_actividades.model.Activity;
import com.devemersonc.gestion_de_actividades.model.User;

import java.util.Date;

public class InscriptionDTO {
    private Long id;
    private Date inscription_date;
    private Boolean attendance;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInscription_date() {
        return inscription_date;
    }

    public void setInscription_date(Date inscription_date) {
        this.inscription_date = inscription_date;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }

    public UserDTO getUserDto() {
        return user;
    }

    public void setUserDto(UserDTO user) {
        this.user = user;
    }
}
