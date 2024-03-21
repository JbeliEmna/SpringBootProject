package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CandidatResponse {

    private final UtilisateurResponse uResponse ;

    @Autowired
    public CandidatResponse(UtilisateurResponse uResponse) {
        this.uResponse = uResponse;
    }


    @NotBlank
    @NotNull
    private String CV ;
    @NotNull
    @NotBlank
    private String domaine;

}
