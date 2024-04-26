package com.jbeli.gestion.utilisateurs.OffreEmploi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/offreEmploi")
@RequiredArgsConstructor
@Api(description = "Job offer API having endpoints which are used to interact with gestion utilisateur microservice")
public class OffreEmploiController {

    private final OffreEmploiService offreEmploiService;

    @PostMapping
    @ApiOperation("Used to add Job offer to the system")
    public ResponseEntity<Integer> save(
            @ApiParam("Information about Job offer to be added to the system ")
            @RequestBody @Valid OffreEmlpoiRequest offre
    ) {
        return ResponseEntity
                .accepted().body(offreEmploiService.save(offre));
    }

    @GetMapping("/{offreEmploi-id}")
    public ResponseEntity<OffreEmlpoiResponse> findById(
            @ApiParam("find the Job offer by id")
            @PathVariable("offreEmploi-id") Integer offreEmploiId
    ) {
        return ResponseEntity.ok(offreEmploiService.findById(offreEmploiId));
    }

    @GetMapping
    @ApiOperation("listed all the Job offers exist in the system")
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
    @ApiOperation("chanded the discription of the Job offers exist in the system")
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
