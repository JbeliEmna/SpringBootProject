package com.jbeli.evaluation.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TestResponse {

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
