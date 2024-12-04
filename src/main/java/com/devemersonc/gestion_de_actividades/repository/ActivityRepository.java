package com.devemersonc.gestion_de_actividades.repository;

import com.devemersonc.gestion_de_actividades.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    //Obtener una actividad específica con sus usuarios
    @Query("SELECT a FROM Activity a LEFT JOIN FETCH a.inscriptions i LEFT JOIN FETCH i.user WHERE a.id = :activityId")
    Activity findActivityWithUsers(@Param("activityId") Long activityId);

    @Query("SELECT a FROM Activity a LEFT JOIN FETCH a.inscriptions i LEFT JOIN FETCH i.user")
    List<Activity> findAllActivitiesWithUsers();
}
