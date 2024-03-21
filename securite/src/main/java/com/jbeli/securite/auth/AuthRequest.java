package com.jbeli.securite.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequest {
    @Column(unique = true)
    @NotNull(message = " email ne peut pas être vide")
    @NotEmpty(message = "email ne peut pas être vide")
    @Email
    private String email;

    @NotBlank
    @Size(min=8 , max=20)
    @Column(unique = true)
    @NotNull(message = "le mot de passe ne peut pas être vide")
    private String motDePasse;
}
