package com.jbeli.evaluation.interview;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    boolean findByDateDebut(Date dateDebut);

    boolean findByDateFin(Date dateFin);
}
