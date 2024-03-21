package com.jbeli.securite.auth;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthMapper {

    @Autowired
    private Utilisateur utilisateur;

    public Utilisateur toUtilisateur(RegisterRequest s){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(s.getNom());
        utilisateur.setEmail(s.getEmail());
        utilisateur.setMotDePasse(s.getMotDePasse());
        return utilisateur;
    }
}