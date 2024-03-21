package com.jbeli.gestion.utilisateurs.societe;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class SocieteMapper {

    public SocieteResponse toSocieteDto(Societe s) {
        return SocieteResponse.builder()
                .email(s.getEmail())
                .Nom(s.getNom())
                .build();
    }

    public Societe toSociete(SocieteRequest s) {
        return Societe.builder()
                .id(s.getId())
                .Nom(s.getNom())
                .build();
    }
}

