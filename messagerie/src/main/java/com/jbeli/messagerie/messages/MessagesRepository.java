package com.jbeli.messagerie.messages;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {
    boolean findByDate(Date date);

    boolean findByEtat(EtatEnum etat);
}
