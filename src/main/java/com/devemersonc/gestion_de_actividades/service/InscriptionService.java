package com.devemersonc.gestion_de_actividades.service;

import com.devemersonc.gestion_de_actividades.dto.InscriptionDTO;
import com.devemersonc.gestion_de_actividades.dto.RegisterInscriptionDTO;
import com.devemersonc.gestion_de_actividades.model.Inscription;

import java.util.List;

public interface InscriptionService {
    List<InscriptionDTO> getInscriptions();
    InscriptionDTO getInscription(Long id);
    void saveInscription(Long id);
    void deleteInscription(Long id);
    void updateAttendance(Long idInscription, Boolean attendance);
    InscriptionDTO convertEntityToDto(Inscription inscription);
}
