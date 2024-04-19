package com.jbeli.gestion.utilisateurs.utilisateur;

import com.jbeli.messagerie.salonDiscussion.SalonDiscussion;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Utilisateur {


    private Integer id ;

    private String nom;

    private String email;

    private String motDePasse;

    private String numTelephone;

    private String donneesGeo;

    @ManyToMany
    @JoinTable(name = "utilisateur_SalonDiscussion",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "SalonDiscussion_id"))
    private Set<SalonDiscussion> salonDiscussions = new HashSet<>();



}
