package com.jbeli.evaluation.pieceJointe;


import com.jbeli.evaluation.test.Test;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotBlank
    @NotEmpty
    private String sujet;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

}
