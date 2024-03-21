package com.jbeli.gestion.utilisateurs.recruteur;


import com.jbeli.gestion.utilisateurs.candidat.CandidatResponse;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurMapper;
import lombok.Builder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class RecruteurMapper {

    private final UtilisateurMapper mapper ;

    public RecruteurResponse toRecruteurDto(Recruteur r) {
        return RecruteurResponse.builder()
                .id(r.getId())
                .email(r.getEmail())
                .motDePasse(r.getMotDePasse())
                .numTelephone(r.getNumTelephone())
                .donneesGeo(r.getDonneesGeo())
                .type(r.getType())
                .build();
    }
    public Recruteur toRecruteur(RecruteurRequest r){
        return RecruteurResponse.builder()
                .id(r.getId())
                .email(r.getEmail())
                .motDePasse(r.getMotDePasse())
                .numTelephone(r.getNumTelephone())
                .donneesGeo(r.getDonneesGeo())
                .build();
    }
}
