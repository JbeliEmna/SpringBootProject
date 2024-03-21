package com.jbeli.messagerie.messages;

import java.util.Date;
import java.util.List;

public interface MessagesService {

    MessagesResponse findById(Integer id);
    List<MessagesResponse> findAll();
    void deleteById(Integer id);

    Integer save(MessagesRequest m);

    boolean MessageExisteParDate(Date date);

    boolean MessageExisteParEtat(EtatEnum etat);

}
