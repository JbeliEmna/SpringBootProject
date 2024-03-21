package com.jbeli.gestion.utilisateurs.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>  {


    boolean findByEmail(String email);

    boolean findBynumTelephone(String numTelephone);
}
