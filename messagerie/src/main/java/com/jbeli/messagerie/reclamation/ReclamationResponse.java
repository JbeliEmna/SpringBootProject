package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.MessagesResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@Entity
public class ReclamationResponse {

    private final MessagesResponse messagesResponse;

    @Column(nullable = false)
    private String sujet;

}
