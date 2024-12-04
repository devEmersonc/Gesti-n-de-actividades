package com.devemersonc.gestion_de_actividades.dto;

public class InscriptionUserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Boolean attendance;

    public InscriptionUserDTO (Long id, String firstname, String lastname, Boolean attendance) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.attendance = attendance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }
}
