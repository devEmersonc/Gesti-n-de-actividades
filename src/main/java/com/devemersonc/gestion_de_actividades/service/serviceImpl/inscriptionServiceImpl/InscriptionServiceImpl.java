package com.devemersonc.gestion_de_actividades.service.serviceImpl.inscriptionServiceImpl;

import com.devemersonc.gestion_de_actividades.dto.InscriptionDTO;
import com.devemersonc.gestion_de_actividades.dto.RegisterInscriptionDTO;
import com.devemersonc.gestion_de_actividades.exception.InsufficientQuotasException;
import com.devemersonc.gestion_de_actividades.exception.ResourceNotFoundException;
import com.devemersonc.gestion_de_actividades.model.Activity;
import com.devemersonc.gestion_de_actividades.model.Inscription;
import com.devemersonc.gestion_de_actividades.model.User;
import com.devemersonc.gestion_de_actividades.repository.ActivityRepository;
import com.devemersonc.gestion_de_actividades.repository.InscriptionRepository;
import com.devemersonc.gestion_de_actividades.service.ActivityService;
import com.devemersonc.gestion_de_actividades.service.InscriptionService;
import com.devemersonc.gestion_de_actividades.service.SecurityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionServiceImpl implements InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final ActivityRepository activityRepository;
    private final SecurityService securityService;
    private final ActivityService activityService;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository, ActivityRepository activityRepository, SecurityService securityService, ActivityService activityService) {
        this.inscriptionRepository = inscriptionRepository;
        this.activityRepository = activityRepository;
        this.securityService = securityService;
        this.activityService = activityService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public List<InscriptionDTO> getInscriptions() {
        return inscriptionRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public InscriptionDTO getInscription(Long id) {
        Inscription inscription = inscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La inscripción ingresada no existe."));
        return this.convertEntityToDto(inscription);
    }

    @Override
    public void saveInscription(Long id, RegisterInscriptionDTO registerInscriptionDTO) {
        Inscription inscription = new Inscription();
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La actividad ingresada no existe."));
        User user = securityService.getAuthenticatedUser();
        if(activity.getAvailable_slots() > 0) {
            inscription.setUser(user);
            inscription.setActivity(activity);
            activity.setAvailable_slots(activity.getAvailable_slots()-1);
            activityRepository.save(activity);
            inscriptionRepository.save(inscription);
        }else {
            throw new InsufficientQuotasException();
        }
    }

    @Override
    public void deleteInscription(Long id) {
        Inscription inscription = inscriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La inscripción ingresada no existe."));
        inscriptionRepository.deleteById(inscription.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void updateAttendance(Long idInscription, Boolean attendance) {
        Inscription inscription = inscriptionRepository.findById(idInscription).orElseThrow(() -> new ResourceNotFoundException("La inscripción ingresada no existe."));
        inscription.setAttendance(attendance);
        inscriptionRepository.save(inscription);
    }

    @Override
    public InscriptionDTO convertEntityToDto(Inscription inscription) {
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        inscriptionDTO.setId(inscription.getId());
        inscriptionDTO.setInscription_date(inscription.getInscription_date());
        inscriptionDTO.setUser(inscription.getUser());
        inscriptionDTO.setActivity(inscription.getActivity());
        inscriptionDTO.setAttendance(inscription.getAttendance());
        return inscriptionDTO;
    }
}
