package com.jbeli.evaluation.interview;

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
public class InterviewRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateFin;
}
