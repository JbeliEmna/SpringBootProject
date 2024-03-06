package com.jbeli.gestion.utilisateurs.administrateur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class AdministrateurResponse  {
    private final UtilisateurResponse uResponse ;

    @Autowired
    public AdministrateurResponse(UtilisateurResponse uResponse) {
        this.uResponse = uResponse;
    }
}
