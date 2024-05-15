package com.jbeli.gestion.utilisateurs.utilisateur;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jdk.jshell.Snippet;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class UtilisateurResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "nom ne peut pas être vide")
    @NotBlank(message = "nom ne peut pas être vide")
    private String nom;

    @Email
    @Column(unique = true)
    @NotNull(message = " email ne peut pas être vide")
    private String email;

    @NotBlank
    @Size(min=8 , max=20)
    @Column(unique = true)
    @NotNull(message = " le mot de passe ne peut pas être vide")
    private String motDePasse;

    @NotNull
    @Pattern(regexp="[0-9]{8}")
    @NotNull(message="Le numéro de téléphone ne peut pas être vide")
    private String numTelephone;

    @NotNull(message="les données géographiques ne peuvent pas  être vide")
    private String donneesGeo;

}
