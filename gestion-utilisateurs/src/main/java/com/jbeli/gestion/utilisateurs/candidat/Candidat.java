package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.OffreEmploi.OffreEmploi;
import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@ApiModel("Contains all the attributes required under Candidat entity")
public class Candidat extends Utilisateur {


    @ApiModelProperty("the CV of the candidat")
    private String CV ;

    @ApiModelProperty("the domaine of the candidat")
    private String domaine;

    @ManyToMany
    @JoinTable(name = "candidat_offre",
            joinColumns = @JoinColumn(name = "candidat_id"),
            inverseJoinColumns = @JoinColumn(name = "offre_id"))
    private Set<OffreEmploi> offres = new HashSet<>();
}
