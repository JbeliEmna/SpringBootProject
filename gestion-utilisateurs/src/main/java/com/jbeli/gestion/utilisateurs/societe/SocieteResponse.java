package com.jbeli.gestion.utilisateurs.societe;;
import jakarta.validation.constraints.Email;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SocieteResponse {

    @NonNull
    private String Nom;
    @Email
    private String email;
}
