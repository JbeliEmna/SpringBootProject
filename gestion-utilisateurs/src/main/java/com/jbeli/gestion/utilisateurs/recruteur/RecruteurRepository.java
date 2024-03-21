package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.candidat.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruteurRepository extends JpaRepository<Recruteur, Integer> {
    List<Recruteur> findByType(String type);
}
