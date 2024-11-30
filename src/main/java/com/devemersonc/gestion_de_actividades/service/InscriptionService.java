package com.devemersonc.gestion_de_actividades.service;

import com.devemersonc.gestion_de_actividades.dto.InscriptionDTO;
import com.devemersonc.gestion_de_actividades.dto.RegisterInscriptionDTO;
import com.devemersonc.gestion_de_actividades.model.Inscription;

import java.util.List;

public interface InscriptionService {
    List<InscriptionDTO> getInscriptions();
    InscriptionDTO getInscription(Long id);
    void saveInscription(Long id, RegisterInscriptionDTO registerInscriptionDTO);
    void deleteInscription(Long id);
    InscriptionDTO convertEntityToDto(Inscription inscription);
}
