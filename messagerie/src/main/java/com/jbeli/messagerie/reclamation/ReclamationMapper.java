package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.MessagesMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ReclamationMapper {

    public ReclamationResponse toReclamationDto(Reclamation r) {
       ReclamationResponse reclamationResponse = new ReclamationResponse();
        reclamationResponse.setId(r.getId());
        reclamationResponse.setSujet(r.getSujet());
        return reclamationResponse;
    }

    public Reclamation toReclamation(ReclamationRequest r){
        Reclamation reclamation = new Reclamation();
        reclamation.setId(r.getId());
        reclamation.setMessage(r.getMessage());
        return reclamation;
    }
}
