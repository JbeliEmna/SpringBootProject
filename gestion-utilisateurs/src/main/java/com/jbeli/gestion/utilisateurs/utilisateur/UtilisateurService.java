package com.jbeli.gestion.utilisateurs.utilisateur;

import com.jbeli.gestion.utilisateurs.common.PageResponse;

import java.util.List;

public interface UtilisateurService {

    UtilisateurResponse  findById(Integer id);

    PageResponse<UtilisateurResponse> findAll(int page, int size);

    void deleteById(Integer id);
    Integer save(UtilisateurRequest u);

    boolean utilisateurExisteParEmail(String email);
    boolean utilisateurExisteParNumTel(String numTelephone);

    void changerMotDePasse(Integer id, String nouveauMotDePasse);

    List<Utilisateur> findAllUsersBySalonDiscussion(Integer salonDiscussionId);
}
