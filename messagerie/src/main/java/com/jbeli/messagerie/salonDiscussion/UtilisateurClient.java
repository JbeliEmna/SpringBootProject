package com.jbeli.messagerie.salonDiscussion;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gestion-utilisateur-service")
public interface UtilisateurClient {

    @GetMapping("/utilisateur/{id}")
    Utilisateur findById(@PathVariable Integer id);
}
