package com.jbeli.gestion.utilisateurs.candidat;

import lombok.Builder;
import org.springframework.stereotype.Service;

@Builder
@Service
public class CandidatMapper {

    public CandidatResponse toCandidatDto(Candidat c) {
        return CandidatResponse.builder()
                .id(c.getId())
                .email(c.getEmail())
                .motDePasse(c.getMotDePasse())
                .numTelephone(c.getNumTelephone())
                .donneesGeo(c.getDonneesGeo())
                .CV(c.getCV())
                .domaine(c.getDomaine())
                .build();
    }
    public Candidat toCandidat(CandidatRequest c) {
        return Candidat.builder()
                .id(c.getId())
                .email(c.getEmail())
                .motDePasse(c.getMotDePasse())
                .numTelephone(c.getNumTelephone())
                .donneesGeo(c.getDonneesGeo())
                .build();
    }
}
