package com.jbeli.evaluation.pieceJointe;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PieceJointeResponse {


    @NotBlank
    @NotEmpty
    private String sujet;
}
