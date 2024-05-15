package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.MessagesResponse;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class ReclamationResponse extends MessagesResponse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String sujet;

}
