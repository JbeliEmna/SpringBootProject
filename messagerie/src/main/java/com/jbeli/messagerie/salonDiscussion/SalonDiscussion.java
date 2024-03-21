package com.jbeli.messagerie.salonDiscussion;


import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import com.jbeli.messagerie.messages.Messages;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SalonDiscussion {

    private Integer id ;

    private String titre;

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Messages> messages = new ArrayList<>();

    @ManyToMany(mappedBy = "salonDiscussions")
    private Set<Utilisateur> utilisateurss = new HashSet<>();

    @Getter
    private List<Utilisateur> utilisateurs;




}
