package com.jbeli.securite.auth;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    @NotNull(message = "le nom ne peut pas être vide")
    @NotBlank(message = "le nom ne peut pas être vide")
    private String nom;

    @NotNull(message = "le prenom ne peut pas être vide")
    @NotBlank(message = "le prenom ne peut pas être vide")
    private String prenom;

    @Column(unique = true)
    @NotNull(message = " email ne peut pas être vide")
    @NotEmpty(message = "email ne peut pas être vide")
    @Email
    private String email;

    @NotEmpty(message = "le mot de passe ne peut pas être vide")
    @Size(min=8 , max=20 , message = "le mot de passe doit être de 8 caractères minimum et 20 ...")
    @Column(unique = true)
    @NotNull(message = "le mot de passe ne peut pas être vide")
    private String motDePasse;

    @NotNull(message = "la date de naissance ne peut pas être vide")
    @NotBlank(message = "la date de naissance ne peut pas être vide")
    private LocalDate DateNaissance;

}
