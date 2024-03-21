package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.MessagesRequest;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@Entity
public class ReclamationRequest {

    private final MessagesRequest messagesRequest;
}
