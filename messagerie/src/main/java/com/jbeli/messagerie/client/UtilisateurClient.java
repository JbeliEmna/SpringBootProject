package com.jbeli.messagerie.client;

import com.jbeli.messagerie.salonDiscussion.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "utilisateur-service" , url="&{application.config.utilisateurs-url")
public interface UtilisateurClient {

    @GetMapping("/salonDiscussion/{salonDiscussion-id}")
    List<Utilisateur> findAllUsersBySalonDiscussion(@PathVariable("salonDiscussion-id") Integer salonDiscussionId);
}
