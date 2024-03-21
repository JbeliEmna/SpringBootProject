package com.jbeli.gestion.utilisateurs.utilisateur;

import com.jbeli.gestion.utilisateurs.common.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateur")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    @Autowired
    private SalonDiscussionClient salonDiscussionClient;

    @PostMapping("/utilisateur/{utilisateurId}/salon/{salonId}")
    public void ajouterUtilisateurAuSalon(@PathVariable Integer utilisateurId, @PathVariable Integer salonId) {

        salonDiscussionClient.ajouterUtilisateurAuSalon(utilisateurId, salonId);
    }



    @PostMapping
    public ResponseEntity<Integer> save(
            @RequestBody @Valid UtilisateurRequest utilisateur
    ) {
        return ResponseEntity
                .accepted().body(utilisateurService.save(utilisateur));
    }

    @GetMapping("/{utilisateur-id}")
    public ResponseEntity<UtilisateurResponse> findById(
            @PathVariable("utilisateur-id") Integer utilisateurId
    ) {
        return ResponseEntity.ok(utilisateurService.findById(utilisateurId));
    }

    @GetMapping
    public ResponseEntity<PageResponse<UtilisateurResponse>> findAll(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "4", required = false) int size
    ) {
        return ResponseEntity.ok(utilisateurService.findAll(page, size));
    }
    @DeleteMapping("/{utilisateur-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        UtilisateurResponse u = utilisateurService.findById(id);
        if (u != null) {
            utilisateurService.deleteById(id);
            return ResponseEntity.ok("Utilisateur supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/existe/{utilisateur-email}")
    public boolean utilisateurExisteParEmail(@PathVariable String email){
        return utilisateurService.utilisateurExisteParEmail(email);
    }
    @GetMapping("/existe/{utilisateur-NumTel}")
    public boolean utilisateurExisteParNumTel(String numTelephone){
        return utilisateurService.utilisateurExisteParNumTel(numTelephone);
    }

    @PostMapping("/changerMotDePasse/{utilisateur-id}")
    public ResponseEntity changerMotDePasse( @PathVariable Integer id, @PathVariable String nouveauMotDePasse){
        UtilisateurResponse u= utilisateurService.findById(id);
        UtilisateurRequest request = new UtilisateurRequest();
        if(u !=null){
            UtilisateurRequest.builder()
                    .id(u.getId())
                    .email(u.getEmail())
                    .motDePasse(u.getMotDePasse())
                    .numTelephone(u.getNumTelephone())
                    .build();
            utilisateurService.deleteById(id);
            return ResponseEntity
                    .accepted().body(utilisateurService.save(request));

        } else {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("La requête est invalide.");
        }
    }





}
