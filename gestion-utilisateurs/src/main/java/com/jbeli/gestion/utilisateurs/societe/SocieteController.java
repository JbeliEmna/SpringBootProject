package com.jbeli.gestion.utilisateurs.societe;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/societe")
@RequiredArgsConstructor
public class SocieteController {

    private final SocieteService societeService;

    @GetMapping("/{societe-id}")
    public ResponseEntity<SocieteResponse> findById(
            @PathVariable("societe-id") Integer societeId
    ) {
        return ResponseEntity.ok(societeService.findById(societeId));
    }

    @GetMapping
    public ResponseEntity<List<SocieteResponse>> findAll() {
        return ResponseEntity.ok(societeService.findAll());
    }
    @DeleteMapping("/{societe-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        SocieteResponse societe = societeService.findById(id);
        if (societe != null) {
            societeService.deleteById(id);
            return ResponseEntity.ok("Societe supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/existe/{societe-email}")
    public boolean SocieteExisteParEmail(@PathVariable String email){
        return societeService.SocieteExisteParEmail(email);
    }
}
