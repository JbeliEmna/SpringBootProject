package com.jbeli.gestion.utilisateurs.societe;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/societe")
@RequiredArgsConstructor
@Api(description = "Company API having endpoints which are used to interact with gestion utilisateur microservice")
public class SocieteController {

    private final SocieteService societeService;

    @GetMapping("/{societe-id}")
    public ResponseEntity<SocieteResponse> findById(
            @ApiParam("find the company by id ")
            @PathVariable("societe-id") Integer societeId
    ) {
        return ResponseEntity.ok(societeService.findById(societeId));
    }

    @GetMapping
    @ApiOperation("listed all the companies exist in the system")
    public ResponseEntity<List<SocieteResponse>> findAll() {
        return ResponseEntity.ok(societeService.findAll());
    }
    @DeleteMapping("/{societe-id}")
    public ResponseEntity deleteById(
            @ApiParam("deleted the company by id ")
            @PathVariable Integer id) {
        SocieteResponse societe = societeService.findById(id);
        if (societe != null) {
            societeService.deleteById(id);
            return ResponseEntity.ok("Societe supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/existe/{societe-email}")
    @ApiOperation("check the company exist in the system or not bu email")
    public boolean SocieteExisteParEmail(
            @ApiParam("the email to find the company ")
            @PathVariable String email){
        return societeService.SocieteExisteParEmail(email);
    }
}
