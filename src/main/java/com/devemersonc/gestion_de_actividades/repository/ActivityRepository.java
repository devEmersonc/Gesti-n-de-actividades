package com.devemersonc.gestion_de_actividades.repository;

import com.devemersonc.gestion_de_actividades.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
