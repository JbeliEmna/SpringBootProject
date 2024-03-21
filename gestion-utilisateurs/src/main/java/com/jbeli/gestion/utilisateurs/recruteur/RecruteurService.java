package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurService;

import java.util.List;

public interface RecruteurService extends UtilisateurService {

    List<Recruteur> rechercherRecruteursParType(String type);

}
