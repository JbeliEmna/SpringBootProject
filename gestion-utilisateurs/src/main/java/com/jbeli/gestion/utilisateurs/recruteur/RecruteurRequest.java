package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class RecruteurRequest {

    private final UtilisateurRequest uRequest ;

    @Autowired
    public RecruteurRequest(UtilisateurRequest uRequest) {

        this.uRequest= uRequest;
    }
}
