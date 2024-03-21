package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.MessagesMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class ReclamationMapper {

    private final MessagesMapper messagesMapper;

    public ReclamationResponse toReclamationDto(Reclamation r) {
        return ReclamationResponse.builder()
                .sujet(r.getSujet())
                .build();
    }

}
