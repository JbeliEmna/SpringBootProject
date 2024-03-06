package com.jbeli.gestion.utilisateurs.utilisateur;

import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class UtilisateurMapper {
    public UtilisateurResponse toStudentDto( Utilisateur u) {
       // return UtilisateurResponse.builder()
          //      .id(u.getId())
            //    .email(u.getEmail())
            //    .motDePasse(u.getMotDePasse())
             //   .numTelephone(u.getNumTelephone())
              //  .donneesGeo(u.getDonneesGeo())
              //  .build();
        UtilisateurResponse uti = new UtilisateurResponse();
        uti.setId(u.getId());
        uti.setEmail(u.getEmail());
        uti.setMotDePasse(u.getMotDePasse());
        uti.setNumTelephone(Integer.parseInt(u.getNumTelephone()));
        return uti;

    }

    public Utilisateur toStudent(UtilisateurRequest u) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(u.getId());
        utilisateur.setEmail(u.getEmail());
        utilisateur.setMotDePasse(u.getMotDePasse());
        utilisateur.setNumTelephone(String.valueOf(u.getNumTelephone()));
        return utilisateur;
    }
}
