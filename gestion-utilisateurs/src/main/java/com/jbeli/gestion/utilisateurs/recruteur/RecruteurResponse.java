package com.jbeli.gestion.utilisateurs.recruteur;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


@Setter
@Getter
@Entity
public class RecruteurResponse extends UtilisateurResponse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NonNull
    private String type;
}

