package com.jbeli.evaluation.interview;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InterviewResponse {

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateFin;
}
