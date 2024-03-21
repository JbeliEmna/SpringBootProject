package com.jbeli.evaluation.pieceJointe;

import java.util.List;

public interface PieceJointeService {
    PieceJointeResponse findById(Integer id);
    List<PieceJointeResponse> findAll();
    void deleteById(Integer id);

    Integer save(PieceJointeRequest p );

    boolean PieceJointeExisteParSujet(String sujet);

}
