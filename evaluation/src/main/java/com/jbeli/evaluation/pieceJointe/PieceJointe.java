package com.jbeli.evaluation.pieceJointe;


import com.jbeli.evaluation.test.Test;
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
public class PieceJointe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

}
