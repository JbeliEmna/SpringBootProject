package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@Builder
@Entity
public class RecruteurRequest {

    private final UtilisateurRequest uRequest ;

    @Autowired
    public RecruteurRequest(UtilisateurRequest uRequest) {

        this.uRequest= uRequest;
    }
}
