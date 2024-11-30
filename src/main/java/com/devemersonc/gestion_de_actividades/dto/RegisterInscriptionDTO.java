package com.devemersonc.gestion_de_actividades.dto;

import com.devemersonc.gestion_de_actividades.model.Activity;
import com.devemersonc.gestion_de_actividades.model.User;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class RegisterInscriptionDTO {
    private User user;
    private Activity activity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
