package com.jbeli.gestion.utilisateurs.recruteur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class RecruteurMapper {

    public RecruteurResponse toRecruteurDto(Recruteur recruteur) {
        RecruteurResponse recruteurResponse = new RecruteurResponse();
        recruteurResponse.setType(recruteur.getType());
        recruteurResponse.setId(recruteur.getId());
        return recruteurResponse;

    }

    public Recruteur toRecruteur(RecruteurRequest recruteurRequest) {
        Recruteur recruteur = new Recruteur();
        recruteur.setNom(recruteurRequest.getNom());
        recruteur.setEmail(recruteurRequest.getEmail());
        recruteur.setMotDePasse(recruteurRequest.getMotDePasse());
        recruteur.setNumTelephone(recruteurRequest.getNumTelephone());
        return recruteur;
    }
}
