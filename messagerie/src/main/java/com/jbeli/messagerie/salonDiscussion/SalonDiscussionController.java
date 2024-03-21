package com.jbeli.messagerie.salonDiscussion;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salonDiscussion")
@RequiredArgsConstructor
public class SalonDiscussionController {

    @Autowired
    private final SalonDiscussionRepository salonDiscussionRepository;
    @Autowired
    private final UtilisateurClient utilisateurClient;

    private final SalonDiscussionService salonDiscussionService;

    @PostMapping("/salon/{salonId}/utilisateur/{utilisateurId}")
    public void ajouterUtilisateurAuSalon(@PathVariable Integer salonId, @PathVariable Integer utilisateurId) {
        SalonDiscussion salon = salonDiscussionRepository.findById(salonId).orElseThrow();
        Utilisateur utilisateur = utilisateurClient.findById(utilisateurId);
        salon.getUtilisateurs().add(utilisateur);
        salonDiscussionRepository.save(salon);

    }

    @PostMapping
    public ResponseEntity<Integer> save(
            @RequestBody @Valid SalonDiscussionRequest discussion
    ) {
        return ResponseEntity
                .accepted().body(salonDiscussionService.save(discussion));
    }

    @GetMapping("/{salonDiscussion-id}")
    public ResponseEntity<SalonDiscussionResponse> findById(
            @PathVariable("salonDiscussion-id") Integer discussionId
    ) {
        return ResponseEntity.ok(salonDiscussionService.findById(discussionId));
    }

    @GetMapping
    public ResponseEntity<List<SalonDiscussionResponse>> findAll() {

        return ResponseEntity.ok(salonDiscussionService.findAll());
    }
    @DeleteMapping("/{salonDiscussion-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        SalonDiscussionResponse discussion= salonDiscussionService.findById(id);
        if (discussion != null) {
            salonDiscussionService.deleteById(id);
            return ResponseEntity.ok("Salon discussion supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/existe_par_titre/{salonDiscussion-titre}")
    public boolean SalonDiscussionExisteParTitre(@PathVariable String titre){
        return salonDiscussionService.SalonDiscussionExisteParTitre(titre);
    }

}
