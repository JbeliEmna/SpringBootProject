package com.jbeli.gestion.utilisateurs.candidat;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/candidats")
@RequiredArgsConstructor
public class CandidatController {

    @Autowired
    private final InterviewClient interviewClient;
    private final CandidatService candidatService;


    @PostMapping("/interview/{interviewId}/candidat/{candidatId}")
    public void ajouterCandidatAuInterview(@PathVariable("candidatId") Integer candidatId, @PathVariable("interviewId") Integer interviewId) {

        InterviewClient.ajouterCandidatAuInterview(candidatId, interviewId);

    }

    @GetMapping("/rechercherParDomaine")
    public ResponseEntity<List<Candidat>> rechercherCandidatsParDomaine(@RequestParam("domaine") String domaine) {
        List<Candidat> candidats = candidatService.rechercherCandidatsParDomaine(domaine);
        if (candidats.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(candidats);
    }


}
