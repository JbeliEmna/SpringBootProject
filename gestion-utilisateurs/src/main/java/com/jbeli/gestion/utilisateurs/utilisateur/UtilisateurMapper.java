package com.jbeli.gestion.utilisateurs.utilisateur;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

@Service
@SuperBuilder
public class UtilisateurMapper {
    public UtilisateurResponse toUtilisateurDto( Utilisateur u) {
        return UtilisateurResponse.builder()
                .id(u.getId())
               .email(u.getEmail())
                .motDePasse(u.getMotDePasse())
               .numTelephone(u.getNumTelephone())
               .donneesGeo(u.getDonneesGeo())
               .build();
    }

    public Utilisateur toUtilisateur(UtilisateurRequest u) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(u.getEmail());
        utilisateur.setMotDePasse(u.getMotDePasse());
        utilisateur.setNumTelephone(u.getNumTelephone());
        return utilisateur;
    }
}
