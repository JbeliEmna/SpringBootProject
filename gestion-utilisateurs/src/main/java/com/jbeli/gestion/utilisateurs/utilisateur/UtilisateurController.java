package com.jbeli.gestion.utilisateurs.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {

    @Autowired
    private SalonDiscussionClient salonDiscussionClient;

    @PostMapping("/utilisateur/{utilisateurId}/salon/{salonId}")
    public void ajouterUtilisateurAuSalon(@PathVariable Integer utilisateurId, @PathVariable Integer salonId) {

        salonDiscussionClient.ajouterUtilisateurAuSalon(utilisateurId, salonId);
    }
}
