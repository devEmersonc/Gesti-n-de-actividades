package com.devemersonc.gestion_de_actividades.controller;

import com.devemersonc.gestion_de_actividades.dto.ActivityDTO;
import com.devemersonc.gestion_de_actividades.dto.ActivityDtoWithInscription;
import com.devemersonc.gestion_de_actividades.dto.RegisterActivityDTO;
import com.devemersonc.gestion_de_actividades.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getActivities() {
        List<ActivityDTO> activities = activityService.getActivities();
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id) {
        ActivityDTO activityDTO = activityService.getActivity(id);
        return ResponseEntity.ok(activityDTO);
    }

    @GetMapping("/{activityId}/users")
    public ResponseEntity<ActivityDtoWithInscription> getActivityWithUsers(@PathVariable Long activityId) {
        ActivityDtoWithInscription activityDTO = activityService.getActivityWithUsers(activityId);
        return ResponseEntity.ok(activityDTO);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ActivityDtoWithInscription>> getAllActivitiesWithUsers() {
        List<ActivityDtoWithInscription> activityDTOS = activityService.getAllActivitiesWithUsers();
        return ResponseEntity.ok(activityDTOS);
    }

    @PostMapping
    public ResponseEntity<String> saveActivity(@Valid @RequestBody RegisterActivityDTO registerActivityDTO) {
        activityService.saveActivity(registerActivityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Nueva actividad guardada con éxito.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateActivity(@Valid @RequestBody RegisterActivityDTO registerActivityDTO, @PathVariable Long id) {
        activityService.updateActivity(id, registerActivityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Actividad actualizada con éxito.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok("Actividad eliminada.");
    }
}
