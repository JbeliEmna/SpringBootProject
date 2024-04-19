package com.jbeli.commonservice;

import com.jbeli.gestion.utilisateurs.common.PageResponse;

public interface UtilisateurService {

    UtilisateurResponse  findById(Integer id);

    PageResponse<UtilisateurResponse> findAll(int page, int size);

    void deleteById(Integer id);
    Integer save(UtilisateurRequest u);

    boolean utilisateurExisteParEmail(String email);
    boolean utilisateurExisteParNumTel(String numTelephone);

    void changerMotDePasse(Integer id, String nouveauMotDePasse);
}

