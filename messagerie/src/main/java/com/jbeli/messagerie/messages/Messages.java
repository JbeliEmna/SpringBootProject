package com.jbeli.messagerie.messages;

import com.jbeli.messagerie.salonDiscussion.SalonDiscussion;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;
    private String message;
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private EtatEnum etat;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    private SalonDiscussion salon;



}
