package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Builder
@Setter
@Getter
@Entity
public class RecruteurResponse {

    private final UtilisateurResponse uResponse ;

    @Autowired
    public RecruteurResponse(UtilisateurResponse uResponse, @NonNull String type) {
        this.uResponse = uResponse;
        this.type = type;
    }

    @NonNull
    private String type;
}

