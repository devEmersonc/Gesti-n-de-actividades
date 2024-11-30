package com.devemersonc.gestion_de_actividades.repository;

import com.devemersonc.gestion_de_actividades.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
