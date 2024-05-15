package com.jbeli.gestion.utilisateurs.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>  {


    boolean findByEmail(String email);

    boolean findBynumTelephone(String numTelephone);

    List<Utilisateur> findAllBySalonDiscussionId(Integer salonDiscussionId);
}
