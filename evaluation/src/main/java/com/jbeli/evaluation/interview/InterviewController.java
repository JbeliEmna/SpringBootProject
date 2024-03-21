package com.jbeli.evaluation.interview;

import com.jbeli.gestion.utilisateurs.candidat.Candidat;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/interview")
@RequiredArgsConstructor
public class InterviewController {

    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private CandidatClient candidatClient;

    private final InterviewService service;

    public InterviewController(InterviewRepository interviewRepository, CandidatClient candidatClient, InterviewService service) {
        this.interviewRepository = interviewRepository;
        this.candidatClient = candidatClient;
        this.service = service;
    }

    @PostMapping("/salon/{salonId}/utilisateur/{utilisateurId}")
    public void ajouterUtilisateurAuSalon(@PathVariable Integer salonId, @PathVariable Integer utilisateurId) {
        Interview interview = interviewRepository.findById(salonId).orElseThrow();
        Candidat candidat = CandidatClient.findById(utilisateurId);
        interview.getCandidat().add(candidat);
        interviewRepository.save(interview);

    }


    @GetMapping("/{interview-id}")
    public ResponseEntity<InterviewResponse> findById(
            @PathVariable("interview-id") Integer interviewId
    ) {
        return ResponseEntity.ok(service.findById(interviewId));
    }

    @GetMapping
    public ResponseEntity<List<InterviewResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @DeleteMapping("/{interview-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        InterviewResponse interview = service.findById(id);
        if (interview != null) {
            service.deleteById(id);
            return ResponseEntity.ok("Interview supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> save(
            @RequestBody @Valid InterviewRequest interviewRequest
    ) {
        return ResponseEntity
                .accepted().body(service.save(interviewRequest));
    }

    @GetMapping("/existe/{interview-DateDebut}")
    public boolean interviewExisteParDateDebut(@PathVariable Date dateDebut){
        return service.interviewExisteParDateDebut(dateDebut);
    }

    @GetMapping("/existe/{interview-DateFin}")
    public boolean interviewExisteParDateFin(@PathVariable Date dateFin){
        return service.interviewExisteParDateFin(dateFin);
    }



}
