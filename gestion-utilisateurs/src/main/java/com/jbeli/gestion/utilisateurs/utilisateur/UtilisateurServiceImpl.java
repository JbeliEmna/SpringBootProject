package com.jbeli.gestion.utilisateurs.utilisateur;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository repository;

    @Override
    public Utilisateur findById(Integer id) {
        return null;
    }

    @Override
    public PageResponse<Utilisateur> findAll(int page, int size) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Utilisateur CreateUser(Utilisateur u) {
        return null;
    }
}
