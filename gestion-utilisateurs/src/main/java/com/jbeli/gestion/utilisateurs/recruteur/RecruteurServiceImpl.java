package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurMapper;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRepository;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecruteurServiceImpl extends UtilisateurServiceImpl implements RecruteurService{

    public RecruteurServiceImpl(UtilisateurRepository repository, UtilisateurMapper mapper, RecruteurRepository recruteurRepository) {
        super(repository, mapper);
        this.recruteurRepository = recruteurRepository;
    }

    private final RecruteurRepository recruteurRepository;

    @Override
    public List<Recruteur> rechercherRecruteursParType(String type) {

        return recruteurRepository.findByType(type);
    }




}
