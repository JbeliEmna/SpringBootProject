package com.jbeli.gestion.utilisateurs.administrateur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@Builder
public class AdministrateurResponse  {
    private final UtilisateurResponse uResponse ;

    @Autowired
    public AdministrateurResponse(UtilisateurResponse uResponse) {
        this.uResponse = uResponse;
    }
}
