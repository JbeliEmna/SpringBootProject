package com.jbeli.securite.auth;

import com.jbeli.securite.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthMapper {

    @Autowired
    private User user;

    public User toUtilisateur(RegisterRequest s){
        User utilisateur = new User();
        utilisateur.setNom(s.getNom());
        utilisateur.setEmail(s.getEmail());
        utilisateur.setMotDePasse(s.getMotDePasse());
        return utilisateur;
    }
}