package com.jbeli.gestion.utilisateurs.societe;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe, Integer> {
    boolean findByEmail(String email);
}
