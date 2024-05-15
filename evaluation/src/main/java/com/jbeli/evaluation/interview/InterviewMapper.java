package com.jbeli.evaluation.interview;

import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class InterviewMapper {

    public InterviewResponse toInterviewDto(Interview i) {
        return InterviewResponse.builder()
                .dateDebut(i.getDateDebut())
                .dateFin(i.getDateFin())
                .build();
    }

    public Interview toInterview(InterviewRequest i) {
        return Interview.builder()
                .id(i.getId())
                .dateDebut(i.getDateDebut())
                .dateFin(i.getDateFin())
                .build();
    }

}
