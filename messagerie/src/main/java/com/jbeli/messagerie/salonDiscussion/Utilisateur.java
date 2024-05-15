package com.jbeli.messagerie.salonDiscussion;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Utilisateur {

    private String nom;
    private String email;
    private String motDePasse;
    private String numTelephone;
    private String donneesGeo;
}
