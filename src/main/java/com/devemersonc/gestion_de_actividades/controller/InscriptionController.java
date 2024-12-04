package com.devemersonc.gestion_de_actividades.controller;

import com.devemersonc.gestion_de_actividades.dto.InscriptionDTO;
import com.devemersonc.gestion_de_actividades.dto.RegisterInscriptionDTO;
import com.devemersonc.gestion_de_actividades.service.InscriptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {
    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping
    public ResponseEntity<List<InscriptionDTO>> getInscriptions() {
        List<InscriptionDTO> inscriptions = inscriptionService.getInscriptions();
        return ResponseEntity.ok(inscriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDTO> getInscription(@PathVariable Long id) {
        InscriptionDTO inscription = inscriptionService.getInscription(id);
        return ResponseEntity.ok(inscription);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> saveInscription(@Valid @RequestBody RegisterInscriptionDTO registerInscriptionDTO, @PathVariable Long id) {
        inscriptionService.saveInscription(id, registerInscriptionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inscripción exitosa!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
        return ResponseEntity.ok("Inscripción eliminada.");
    }

    @PutMapping("/attendance/{idInscription}")
    public ResponseEntity<String> markAttendance(@PathVariable Long idInscription, @RequestBody Map<String, Object> request) {
        boolean attendance = (boolean) request.get("attendance");
        inscriptionService.updateAttendance(idInscription, attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body("Asistencia actualizada correctamente.");
    }
}
