package com.jbeli.gestion.utilisateurs.OffreEmploi;


import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class OffreEmploMapper {

    public OffreEmlpoiResponse toOffreEmploiDto(OffreEmploi o) {
        return OffreEmlpoiResponse.builder()
                .description(o.getDescription())
                .build();

    }

    public OffreEmploi toOffreEmlpoi(OffreEmlpoiRequest o) {
        return OffreEmploi.builder()
                .id(o.getId())
                .description((o.getDescription()))
                .build();
    }
}
