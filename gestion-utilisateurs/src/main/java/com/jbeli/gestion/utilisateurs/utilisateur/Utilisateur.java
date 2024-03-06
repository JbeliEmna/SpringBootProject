package com.jbeli.gestion.utilisateurs.utilisateur;

import com.jbeli.gestion.utilisateurs.OffreEmploi.OffreEmploi;
import com.jbeli.messagerie.salonDiscussion.SalonDiscussion;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size (min=8 , max=20)
    @Column(unique = true)
    private String motDePasse;
    @NotBlank(message="Le numéro de téléphone ne peut pas être vide")
    @Pattern(regexp="[0-9]{8}")
    private String numTelephone;
    @NotBlank(message="les données géographiques ne peuvent pas  être vide")
    private String donneesGeo;

    @ManyToMany
    @JoinTable(name = "utilisateur_SalonDiscussion",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "SalonDiscussion_id"))
    private Set<SalonDiscussion> salonDiscussions = new HashSet<>();



}
