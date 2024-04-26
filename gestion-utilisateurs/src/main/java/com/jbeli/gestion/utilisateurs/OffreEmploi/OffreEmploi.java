package com.jbeli.gestion.utilisateurs.OffreEmploi;

import com.jbeli.gestion.utilisateurs.candidat.Candidat;
import com.jbeli.gestion.utilisateurs.recruteur.Recruteur;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Contains all the attributes required under Job offer entity")
public class OffreEmploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("This the unique ID of the job offer , will be generated by the system")
    private Integer id ;

    @ApiModelProperty("the description of the job offer")
    private String description;

    @ManyToMany(mappedBy = "offres")
    private Set<Recruteur> recruteurs = new HashSet<>();

    @ManyToMany(mappedBy = "offres")
    private Set<Candidat> candidats = new HashSet<>();
}
