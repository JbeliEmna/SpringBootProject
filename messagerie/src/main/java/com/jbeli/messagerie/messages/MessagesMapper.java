package com.jbeli.messagerie.messages;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

@Service
@SuperBuilder
public class MessagesMapper {

    public MessagesResponse toMessagesDto(Messages m) {
        return MessagesResponse.builder()
                .date(m.getDate())
                .etat(m.getEtat())
                .build();
    }

    public Messages toMessages(MessagesRequest m) {
        return Messages.builder()
                .id(m.getId())
                .message((m.getMessage()))
                .build();
    }
}
