package com.devemersonc.gestion_de_actividades.service;

import com.devemersonc.gestion_de_actividades.dto.ActivityDTO;
import com.devemersonc.gestion_de_actividades.dto.RegisterActivityDTO;
import com.devemersonc.gestion_de_actividades.model.Activity;

import java.util.List;

public interface ActivityService {
    List<ActivityDTO> getActivities();
    ActivityDTO getActivity(Long id);
    void saveActivity(RegisterActivityDTO registerActivityDTO);
    void updateActivity(Long id, RegisterActivityDTO registerActivityDTO);
    void deleteActivity(Long id);
    ActivityDTO convertEntityToDto(Activity activity);
}
