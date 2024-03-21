package com.jbeli.gestion.utilisateurs.administrateur;


import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurMapper;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRepository;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurServiceImpl extends UtilisateurServiceImpl implements AdministrateurService{

    public AdministrateurServiceImpl(UtilisateurRepository repository, UtilisateurMapper mapper) {
        super(repository, mapper);
    }
}
