package com.jbeli.gestion.utilisateurs.societe;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;

import java.util.List;

public interface SocieteService {
    SocieteResponse findById(Integer id);
    List<SocieteResponse> findAll();

    void deleteById(Integer id);
    Integer save(SocieteRequest u);

    boolean SocieteExisteParEmail(String email);

}
