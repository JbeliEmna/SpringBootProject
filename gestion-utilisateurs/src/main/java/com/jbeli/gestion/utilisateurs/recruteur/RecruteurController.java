package com.jbeli.gestion.utilisateurs.recruteur;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(description = "employer API having endpoints which are used to interact with gestion utilisateur microservice")
public class RecruteurController {
    private final RecruteurService recruteurService;

    @GetMapping("/rechercherParType")
    @ApiOperation("Listed the employers depending on the type")
    public ResponseEntity<List<Recruteur>> rechercherRecruteursParType(
            @ApiParam("the type used to find the employers")
            @RequestParam("type") String type) {
        List<Recruteur> recruteurs = recruteurService.rechercherRecruteursParType(type);
        if (recruteurs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(recruteurs);
    }
}
