package com.jbeli.gestion.utilisateurs.utilisateur;

public interface UtilisateurService {

    Utilisateur findById(Integer id);
    PageResponse<Utilisateur> findAll(int page, int size);
    void deleteById(Integer id);
    Utilisateur CreateUser(Utilisateur u);


}
