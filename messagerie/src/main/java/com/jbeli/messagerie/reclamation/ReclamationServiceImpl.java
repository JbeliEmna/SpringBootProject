package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.MessagesMapper;
import com.jbeli.messagerie.messages.MessagesRepository;
import com.jbeli.messagerie.messages.MessagesServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ReclamationServiceImpl extends MessagesServiceImpl implements ReclamationService {

    private final ReclamationRepository reclamationRepository;

    public ReclamationServiceImpl(MessagesRepository messagesRepository, MessagesMapper mapper, ReclamationRepository reclamationRepository) {
        super(messagesRepository, mapper);
        this.reclamationRepository = reclamationRepository;
    }

    @Override
    public boolean ReclamationExisteParSujet(String sujet) {
        return reclamationRepository.findBySujet(sujet);
    }
}
