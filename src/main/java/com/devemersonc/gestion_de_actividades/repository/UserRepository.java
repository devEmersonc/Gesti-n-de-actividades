package com.devemersonc.gestion_de_actividades.repository;

import com.devemersonc.gestion_de_actividades.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
