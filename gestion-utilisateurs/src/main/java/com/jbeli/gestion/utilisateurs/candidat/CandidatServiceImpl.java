package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurMapper;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRepository;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CandidatServiceImpl extends UtilisateurServiceImpl implements CandidatService {
    public CandidatServiceImpl(UtilisateurRepository repository, UtilisateurMapper mapper, CandidatRepository candidatRepository) {
        super(repository, mapper);
        this.candidatRepository = candidatRepository;
    }
    private final CandidatRepository candidatRepository;


    @Override
    public List<Candidat> rechercherCandidatsParDomaine(String domaine) {
        return candidatRepository.findByDomaine(domaine);
    }

}

