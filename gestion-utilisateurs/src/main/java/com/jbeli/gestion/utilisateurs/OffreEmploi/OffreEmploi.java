package com.jbeli.gestion.utilisateurs.OffreEmploi;

import com.jbeli.gestion.utilisateurs.candidat.Candidat;
import com.jbeli.gestion.utilisateurs.recruteur.Recruteur;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OffreEmploi {


    private Integer id ;

    private String description;

    @ManyToMany(mappedBy = "offres")
    private Set<Recruteur> recruteurs = new HashSet<>();

    @ManyToMany(mappedBy = "offres")
    private Set<Candidat> candidats = new HashSet<>();
}
