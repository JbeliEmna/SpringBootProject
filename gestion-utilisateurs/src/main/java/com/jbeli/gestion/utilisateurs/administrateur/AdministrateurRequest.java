package com.jbeli.gestion.utilisateurs.administrateur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@Builder
public class AdministrateurRequest {
    private final UtilisateurRequest utilisateurRequest ;

    @Autowired
    public AdministrateurRequest(UtilisateurRequest utilisateurRequest) {

        this.utilisateurRequest= utilisateurRequest;
    }
}


