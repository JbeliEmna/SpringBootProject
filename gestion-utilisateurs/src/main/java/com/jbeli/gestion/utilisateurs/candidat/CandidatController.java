package com.jbeli.gestion.utilisateurs.candidat;

import com.jbeli.gestion.utilisateurs.utilisateur.SalonDiscussionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatController {

    @Autowired
    private InterviewClient interviewClient;

    @PostMapping("/interview/{interviewId}/candidat/{candidatId}")
    public void ajouterCandidatAuInterview(@PathVariable("candidatId") Integer candidatId, @PathVariable("interviewId") Integer interviewId) {

        InterviewClient.ajouterCandidatAuInterview(candidatId, interviewId);

    }
}
