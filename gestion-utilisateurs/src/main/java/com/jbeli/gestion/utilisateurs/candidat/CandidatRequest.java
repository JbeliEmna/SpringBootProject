package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidatRequest {

    private final UtilisateurRequest uRequest ;

    @Autowired
    public CandidatRequest(UtilisateurRequest uRequest) {

        this.uRequest= uRequest;
    }
}
