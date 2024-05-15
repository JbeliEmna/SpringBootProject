package com.jbeli.gestion.utilisateurs.candidat;

import lombok.Builder;
import org.springframework.stereotype.Service;


@Service
public class CandidatMapper {

    public CandidatResponse toCandidatDto(Candidat c) {
        CandidatResponse candidatResponse = new CandidatResponse();
        candidatResponse.setId(c.getId());
        candidatResponse.setCV(c.getCV());
        candidatResponse.setDomaine(c.getDomaine());
        return candidatResponse;
    }
    public Candidat toCandidat(CandidatRequest c) {
        Candidat candidat = new Candidat();
        candidat.setNom(c.getNom());
        candidat.setEmail(c.getEmail());
        candidat.setMotDePasse(c.getMotDePasse());
        candidat.setNumTelephone(c.getNumTelephone());
        return candidat;
    }
}
