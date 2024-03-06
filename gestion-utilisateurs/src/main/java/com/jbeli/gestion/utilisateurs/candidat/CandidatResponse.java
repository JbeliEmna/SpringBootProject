package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidatResponse {

    private final UtilisateurResponse uResponse ;

    @Autowired
    public CandidatResponse(UtilisateurResponse uResponse) {
        this.uResponse = uResponse;
    }

}
