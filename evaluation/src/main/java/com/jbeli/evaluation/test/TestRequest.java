package com.jbeli.evaluation.test;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TestRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(nullable = false )
    @Range(min = 0, max = 20, message = "La note doit être comprise entre 0 et 20")
    private int note;
}
