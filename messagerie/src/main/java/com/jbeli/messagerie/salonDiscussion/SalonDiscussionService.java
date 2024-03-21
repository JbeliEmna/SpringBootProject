package com.jbeli.messagerie.salonDiscussion;


import java.util.Date;
import java.util.List;

public interface SalonDiscussionService {
    SalonDiscussionResponse findById(Integer id);
    List<SalonDiscussionResponse> findAll();
    void deleteById(Integer id);

    Integer save(SalonDiscussionRequest s);

    boolean SalonDiscussionExisteParTitre(String titre);

}
