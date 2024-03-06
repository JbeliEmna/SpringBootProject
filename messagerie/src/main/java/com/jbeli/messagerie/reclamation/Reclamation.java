package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.Messages;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reclamation extends Messages {

    @Column(nullable = false)
    private String sujet;

}
