package com.jbeli.gestion.utilisateurs.utilisateur;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "messagerie-service")
public interface SalonDiscussionClient {
    @PostMapping("/salon/{salonId}/utilisateur/{utilisateurId}")
    void ajouterUtilisateurAuSalon(@PathVariable("utilisateurId") Integer utilisateurId, @PathVariable("salonId") Integer salonId);

}

