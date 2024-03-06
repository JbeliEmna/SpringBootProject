package com.jbeli.messagerie.salonDiscussion;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import com.jbeli.messagerie.PageResponse.PageResponse;
import com.jbeli.messagerie.messages.Messages;

public interface SalonDiscussionService {
    SalonDiscussion findById(Integer id);
    PageResponse<SalonDiscussion> findAll(int page, int size);
    void deleteById(Integer id);
    SalonDiscussion CreateUser(SalonDiscussion u);

}
