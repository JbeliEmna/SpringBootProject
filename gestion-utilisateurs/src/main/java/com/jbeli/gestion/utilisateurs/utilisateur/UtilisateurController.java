package com.jbeli.gestion.utilisateurs.utilisateur;

import com.jbeli.gestion.utilisateurs.common.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@RequiredArgsConstructor
@Api(description = "Job offer API having endpoints which are used to interact with gestion utilisateur microservice")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
  //  @Autowired
   //private SalonDiscussionClient salonDiscussionClient;

    //@PostMapping("/utilisateur/{utilisateurId}/salon/{salonId}")
    //public void ajouterUtilisateurAuSalon(@PathVariable Integer utilisateurId, @PathVariable Integer salonId) {

      //  salonDiscussionClient.ajouterUtilisateurAuSalon(utilisateurId, salonId);}
    @GetMapping("/salonDiscussion/{salonDiscussion-id}")
    public ResponseEntity<List<Utilisateur>> findAllUsers(@PathVariable("salonDiscussion-id") Integer salonDiscussionId){
        return ResponseEntity.ok((utilisateurService.findAllUsersBySalonDiscussion(salonDiscussionId)));
    }




    @PostMapping
    @ApiOperation("Used to add user to the system")
    public ResponseEntity<Integer> save(
            @ApiParam("Information about user to be added to the system ")
            @RequestBody @Valid UtilisateurRequest utilisateur
    ) {
        return ResponseEntity
                .accepted().body(utilisateurService.save(utilisateur));
    }

    @GetMapping("/{utilisateur-id}")
    public ResponseEntity<UtilisateurResponse> findById(
            @ApiParam("find user by id ")
            @PathVariable("utilisateur-id") Integer utilisateurId
    ) {
        return ResponseEntity.ok(utilisateurService.findById(utilisateurId));
    }

    @GetMapping
    @ApiOperation("listed all the usersexist in the system")
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
    @ApiOperation("find user by email")
    public boolean utilisateurExisteParEmail(@PathVariable String email){
        return utilisateurService.utilisateurExisteParEmail(email);
    }
    @GetMapping("/existe/{utilisateur-NumTel}")
    @ApiOperation("find user by phone number")
    public boolean utilisateurExisteParNumTel(String numTelephone){
        return utilisateurService.utilisateurExisteParNumTel(numTelephone);
    }

    @PostMapping("/changerMotDePasse/{utilisateur-id}")
    @ApiOperation("change user password on the system")
    public ResponseEntity changerMotDePasse( @PathVariable Integer id, @PathVariable String nouveauMotDePasse){
        UtilisateurResponse u= utilisateurService.findById(id);
        UtilisateurRequest request = new UtilisateurRequest();
        if(u !=null){
            UtilisateurRequest.builder()
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
