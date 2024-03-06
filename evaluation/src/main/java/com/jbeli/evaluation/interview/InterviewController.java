package com.jbeli.evaluation.interview;

import com.jbeli.gestion.utilisateurs.candidat.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterviewController {

    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private CandidatClient candidatClient;

    @PostMapping("/salon/{salonId}/utilisateur/{utilisateurId}")
    public void ajouterUtilisateurAuSalon(@PathVariable Integer salonId, @PathVariable Integer utilisateurId) {
        Interview interview = interviewRepository.findById(salonId).orElseThrow();
        Candidat candidat = CandidatClient.findById(utilisateurId);
        interview.getCandidat().add(candidat);
        interviewRepository.save(interview);

    }
}
