package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class RecruteurResponse {

    private final UtilisateurResponse uResponse ;

    @Autowired
    public RecruteurResponse(UtilisateurResponse uResponse) {
        this.uResponse = uResponse;
    }
}

