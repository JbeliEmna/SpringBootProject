package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.MessagesService;

import java.util.Date;

public interface ReclamationService extends MessagesService {
    boolean ReclamationExisteParSujet(String sujet);


}
