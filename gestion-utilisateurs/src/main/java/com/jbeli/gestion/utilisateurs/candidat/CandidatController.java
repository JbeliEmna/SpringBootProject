package com.jbeli.gestion.utilisateurs.candidat;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/candidats")
@RequiredArgsConstructor
@Api(description = "Candidat API having endpoints which are used to interact with gestion utilisateur microservice")
public class CandidatController {

    @Autowired
    //private final InterviewClient interviewClient;
    private final CandidatService candidatService;


    //@PostMapping("/interview/{interviewId}/candidat/{candidatId}")
    //public void ajouterCandidatAuInterview(@PathVariable("candidatId") Integer candidatId, @PathVariable("interviewId") Integer interviewId) {

      //  InterviewClient.ajouterCandidatAuInterview(candidatId, interviewId);}

    @GetMapping("/rechercherParDomaine")
    @ApiOperation("find Candidat by Domaine")
    public ResponseEntity<List<Candidat>> rechercherCandidatsParDomaine(
            @ApiParam("list of the candidats find by domaine")
            @RequestParam("domaine") String domaine) {
        List<Candidat> candidats = candidatService.rechercherCandidatsParDomaine(domaine);
        if (candidats.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(candidats);
    }


}
