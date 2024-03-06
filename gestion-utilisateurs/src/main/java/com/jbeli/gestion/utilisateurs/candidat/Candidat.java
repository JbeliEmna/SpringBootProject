package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.OffreEmploi.OffreEmploi;
import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Candidat extends Utilisateur {

    @NonNull
    private String CV ;

    @ManyToMany
    @JoinTable(name = "candidat_offre",
            joinColumns = @JoinColumn(name = "candidat_id"),
            inverseJoinColumns = @JoinColumn(name = "offre_id"))
    private Set<OffreEmploi> offres = new HashSet<>();
}
