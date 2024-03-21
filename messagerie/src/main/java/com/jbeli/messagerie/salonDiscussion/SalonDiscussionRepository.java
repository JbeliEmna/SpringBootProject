package com.jbeli.messagerie.salonDiscussion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonDiscussionRepository extends JpaRepository<SalonDiscussion, Integer> {
    boolean findByTitre(String titre);
}
