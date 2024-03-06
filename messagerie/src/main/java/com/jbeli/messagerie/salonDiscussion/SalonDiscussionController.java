package com.jbeli.messagerie.salonDiscussion;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SalonDiscussionController {

    @Autowired
    private SalonDiscussionRepository salonDiscussionRepository;
    @Autowired
    private UtilisateurClient utilisateurClient;

    @PostMapping("/salon/{salonId}/utilisateur/{utilisateurId}")
    public void ajouterUtilisateurAuSalon(@PathVariable Integer salonId, @PathVariable Integer utilisateurId) {
        SalonDiscussion salon = salonDiscussionRepository.findById(salonId).orElseThrow();
        Utilisateur utilisateur = utilisateurClient.findById(utilisateurId);
        salon.getUtilisateurs().add(utilisateur);
        salonDiscussionRepository.save(salon);

}
}
