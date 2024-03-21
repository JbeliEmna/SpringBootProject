package com.jbeli.evaluation.pieceJointe;

import com.jbeli.evaluation.interview.Interview;
import com.jbeli.evaluation.interview.InterviewRequest;
import com.jbeli.evaluation.interview.InterviewResponse;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class PieceJointeMapper {

    public PieceJointeResponse toPieceJointeDto(PieceJointe p) {
        return PieceJointeResponse.builder()
                .sujet(p.getSujet())
                .build();
    }

    public PieceJointe toInterview(PieceJointeRequest p) {
        return PieceJointe.builder()
                .id(p.getId())
                .build();
    }
}
