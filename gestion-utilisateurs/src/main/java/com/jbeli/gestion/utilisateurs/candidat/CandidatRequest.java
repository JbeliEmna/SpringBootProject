package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@Builder
public class CandidatRequest {

    private final UtilisateurRequest uRequest ;

    @Autowired
    public CandidatRequest(UtilisateurRequest uRequest) {

        this.uRequest= uRequest;
    }


}
