package com.jbeli.evaluation.interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    boolean findByDateDebut(Date dateDebut);

    boolean findByDateFin(Date dateFin);
}
