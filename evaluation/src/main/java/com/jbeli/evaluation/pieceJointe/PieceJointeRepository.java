package com.jbeli.evaluation.pieceJointe;

import com.jbeli.evaluation.interview.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceJointeRepository extends JpaRepository<PieceJointe, Integer> {
    boolean PieceJointeExisteParSujet(String sujet);
}
