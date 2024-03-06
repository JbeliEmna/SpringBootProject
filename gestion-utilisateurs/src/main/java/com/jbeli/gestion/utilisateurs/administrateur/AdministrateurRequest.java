package com.jbeli.gestion.utilisateurs.administrateur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class AdministrateurRequest {
    private final UtilisateurRequest uRequest ;

    @Autowired
    public AdministrateurRequest(UtilisateurRequest uRequest) {

        this.uRequest= uRequest;
    }
}


