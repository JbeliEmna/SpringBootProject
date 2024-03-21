package com.jbeli.gestion.utilisateurs.OffreEmploi;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffreEmlpoiResponse {

    @NonNull
    @NotEmpty
    private String description;
}
