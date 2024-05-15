package com.jbeli.gestion.utilisateurs.candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CandidatRepository extends JpaRepository <Candidat, Integer> {
    List<Candidat> findByDomaine(String domaine);
}
