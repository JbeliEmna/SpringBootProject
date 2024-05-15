package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@Entity

public class RecruteurRequest extends UtilisateurRequest{}

