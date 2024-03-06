package com.jbeli.evaluation.test;
import com.jbeli.evaluation.interview.Interview;
import com.jbeli.evaluation.pieceJointe.PieceJointe;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(nullable = false )
    @Range(min = 0, max = 20, message = "La note doit être comprise entre 0 et 20")
    private int note;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    @OneToOne(mappedBy = "test")
    private PieceJointe pieceJointe ;

}
