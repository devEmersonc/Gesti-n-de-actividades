package com.devemersonc.gestion_de_actividades.service.serviceImpl.activityServiceImpl;

import com.devemersonc.gestion_de_actividades.dto.ActivityDTO;
import com.devemersonc.gestion_de_actividades.dto.RegisterActivityDTO;
import com.devemersonc.gestion_de_actividades.exception.ResourceNotFoundException;
import com.devemersonc.gestion_de_actividades.model.Activity;
import com.devemersonc.gestion_de_actividades.model.User;
import com.devemersonc.gestion_de_actividades.repository.ActivityRepository;
import com.devemersonc.gestion_de_actividades.service.ActivityService;
import com.devemersonc.gestion_de_actividades.service.SecurityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final SecurityService securityService;

    public ActivityServiceImpl(ActivityRepository activityRepository, SecurityService securityService) {
        this.activityRepository = activityRepository;
        this.securityService = securityService;
    }

    @Override
    public List<ActivityDTO> getActivities() {
        return activityRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDTO getActivity(Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La actividad ingresada no se ha encontrado."));
        return this.convertEntityToDto(activity);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void saveActivity(RegisterActivityDTO registerActivityDTO) {
        Activity activity = new Activity();
        activity.setName(registerActivityDTO.getName());
        activity.setDescription(registerActivityDTO.getDescription());
        activity.setDate(registerActivityDTO.getDate());
        activity.setHour(registerActivityDTO.getHour());
        activity.setAvailable_slots(registerActivityDTO.getAvailable_slots());
        activity.setPlace(registerActivityDTO.getPlace());

        User user = securityService.getAuthenticatedUser();
        activity.setUser(user);

        activityRepository.save(activity);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void updateActivity(Long id, RegisterActivityDTO registerActivityDTO) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La actividad ingresada no se ha encontrado."));
        activity.setName(registerActivityDTO.getName());
        activity.setDescription(registerActivityDTO.getDescription());
        activity.setDate(registerActivityDTO.getDate());
        activity.setHour(registerActivityDTO.getHour());
        activity.setAvailable_slots(registerActivityDTO.getAvailable_slots());
        activity.setPlace(registerActivityDTO.getPlace());
        activityRepository.save(activity);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteActivity(Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La actividad ingresada no se ha encontrado."));
        activityRepository.deleteById(activity.getId());
    }

    @Override
    public ActivityDTO convertEntityToDto(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setName(activity.getName());
        activityDTO.setDescription(activity.getDescription());
        activityDTO.setDate(activity.getDate());
        activityDTO.setHour(activity.getHour());
        activityDTO.setAvailable_slots(activity.getAvailable_slots());
        activityDTO.setPlace(activity.getPlace());
        return activityDTO;
    }
}
