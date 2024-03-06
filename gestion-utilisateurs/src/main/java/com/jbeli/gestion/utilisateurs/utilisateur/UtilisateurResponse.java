package com.jbeli.gestion.utilisateurs.utilisateur;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jdk.jshell.Snippet;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UtilisateurResponse {

    private Integer id;
    @NotNull(message = " email ne peut pas être vide")
    private String email;
    @NotNull(message = " le mot de passe ne peut pas être vide")
    private String motDePasse;
    @NotNull
    @Pattern(regexp="[0-9]{8}")
    @NotNull(message="Le numéro de téléphone ne peut pas être vide")
    private int numTelephone;
    @NotNull(message="les données géographiques ne peuvent pas  être vide")
    private String donneesGeo;

}
