package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidatMapper {

    private final UtilisateurMapper mapper ;

    @Autowired
    public CandidatMapper(UtilisateurMapper mapper) {

        this.mapper= mapper;
    }
}
