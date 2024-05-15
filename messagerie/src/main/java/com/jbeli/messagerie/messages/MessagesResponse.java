package com.jbeli.messagerie.messages;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class MessagesResponse {

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private EtatEnum etat;
}
