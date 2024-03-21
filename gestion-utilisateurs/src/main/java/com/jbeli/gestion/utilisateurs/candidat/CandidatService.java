package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurService;

import java.util.List;

public interface CandidatService extends UtilisateurService {
    List<Candidat> rechercherCandidatsParDomaine(String domaine);


}
