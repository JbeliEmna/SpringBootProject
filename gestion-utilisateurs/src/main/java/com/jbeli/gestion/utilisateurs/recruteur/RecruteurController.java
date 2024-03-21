package com.jbeli.gestion.utilisateurs.recruteur;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/recruteur")
@RequiredArgsConstructor
public class RecruteurController {
    private final RecruteurService recruteurService;

    @GetMapping("/rechercherParType")
    public ResponseEntity<List<Recruteur>> rechercherRecruteursParType(@RequestParam("type") String type) {
        List<Recruteur> recruteurs = recruteurService.rechercherRecruteursParType(type);
        if (recruteurs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(recruteurs);
    }
}
