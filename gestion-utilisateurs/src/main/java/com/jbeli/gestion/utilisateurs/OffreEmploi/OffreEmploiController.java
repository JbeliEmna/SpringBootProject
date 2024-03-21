package com.jbeli.gestion.utilisateurs.OffreEmploi;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/offreEmploi")
@RequiredArgsConstructor
public class OffreEmploiController {

    private final OffreEmploiService offreEmploiService;

    @PostMapping
    public ResponseEntity<Integer> save(
            @RequestBody @Valid OffreEmlpoiRequest offre
    ) {
        return ResponseEntity
                .accepted().body(offreEmploiService.save(offre));
    }

    @GetMapping("/{offreEmploi-id}")
    public ResponseEntity<OffreEmlpoiResponse> findById(
            @PathVariable("offreEmploi-id") Integer offreEmploiId
    ) {
        return ResponseEntity.ok(offreEmploiService.findById(offreEmploiId));
    }

    @GetMapping
    public ResponseEntity<List<OffreEmlpoiResponse>> findAll() {
        return ResponseEntity.ok(offreEmploiService.findAll());
    }
    @DeleteMapping("/{offreEmploi-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        OffreEmlpoiResponse offre = offreEmploiService.findById(id);
        if (offre != null) {
            offreEmploiService.deleteById(id);
            return ResponseEntity.ok("Offre d'emploi supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/changerDescription/{offreEmploi-id}")
    public ResponseEntity changerDescription( @PathVariable Integer id, @PathVariable String nouveauDescription) {
        OffreEmlpoiResponse offre = offreEmploiService.findById(id);
        OffreEmlpoiRequest request = new OffreEmlpoiRequest();
        if (offre != null) {
            OffreEmlpoiRequest.builder()
                    .id(id)
                    .description(offre.getDescription())
                    .build();
            offreEmploiService.deleteById(id);
            return ResponseEntity
                    .accepted().body(offreEmploiService.save(request));

        } else {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("La requête est invalide.");
        }
    }
}
