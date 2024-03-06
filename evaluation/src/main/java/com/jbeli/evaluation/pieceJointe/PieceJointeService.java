package com.jbeli.evaluation.pieceJointe;

import com.jbeli.evaluation.PageResponse;
import com.jbeli.evaluation.interview.Interview;

public interface PieceJointeService {
    PieceJointe findById(Integer id);
    PageResponse<PieceJointe> findAll(int page, int size);
    void deleteById(Integer id);

}
