package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class CandidatResponse extends UtilisateurResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotBlank
    @NotNull
    private String CV ;
    @NotNull
    @NotBlank
    private String domaine;

}
