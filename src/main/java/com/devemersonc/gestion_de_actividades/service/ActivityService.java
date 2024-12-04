package com.devemersonc.gestion_de_actividades.service;

import com.devemersonc.gestion_de_actividades.dto.ActivityDTO;
import com.devemersonc.gestion_de_actividades.dto.ActivityDtoWithInscription;
import com.devemersonc.gestion_de_actividades.dto.InscriptionUserDTO;
import com.devemersonc.gestion_de_actividades.dto.RegisterActivityDTO;
import com.devemersonc.gestion_de_actividades.model.Activity;
import com.devemersonc.gestion_de_actividades.model.Inscription;

import java.util.List;

public interface ActivityService {
    List<ActivityDTO> getActivities();
    ActivityDTO getActivity(Long id);
    ActivityDtoWithInscription getActivityWithUsers(Long activityId);
    List<ActivityDtoWithInscription> getAllActivitiesWithUsers();
    void saveActivity(RegisterActivityDTO registerActivityDTO);
    void updateActivity(Long id, RegisterActivityDTO registerActivityDTO);
    void deleteActivity(Long id);
    ActivityDTO convertEntityToDto(Activity activity);
    ActivityDtoWithInscription convertEntityToDtoWithInscriptions(Activity activity);

    List<InscriptionUserDTO> convertInscriptionToDto(List<Inscription> inscriptions);
     ActivityDtoWithInscription convertEntityToDtoWithInscriptionsTest(Activity activity);
}
