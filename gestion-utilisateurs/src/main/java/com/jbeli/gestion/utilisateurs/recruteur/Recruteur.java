package com.jbeli.gestion.utilisateurs.recruteur;


import com.jbeli.gestion.utilisateurs.OffreEmploi.OffreEmploi;
import com.jbeli.gestion.utilisateurs.societe.Societe;
import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;


import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Recruteur extends Utilisateur {

    @NonNull
    private String type;
    @OneToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    @ManyToMany
    @JoinTable(name = "recruteur_offre",
            joinColumns = @JoinColumn(name = "recruteur_id"),
            inverseJoinColumns = @JoinColumn(name = "offre_id"))
    private Set<OffreEmploi> offres = new HashSet<>();
}
