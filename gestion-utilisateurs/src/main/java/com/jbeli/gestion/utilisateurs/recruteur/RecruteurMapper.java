package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RecruteurMapper {

    private final UtilisateurMapper mapper ;

    @Autowired
    public RecruteurMapper(UtilisateurMapper mapper) {

        this.mapper= mapper;
    }
}
