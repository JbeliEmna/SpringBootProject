package com.jbeli.evaluation.interview;


import java.util.Date;
import java.util.List;

public interface InterviewService {
    InterviewResponse findById(Integer id);
    List<InterviewResponse> findAll();
    void deleteById(Integer id);
    Integer save(InterviewRequest u);

    boolean interviewExisteParDateDebut(Date dateDebut);

    boolean interviewExisteParDateFin(Date dateFin);



}
