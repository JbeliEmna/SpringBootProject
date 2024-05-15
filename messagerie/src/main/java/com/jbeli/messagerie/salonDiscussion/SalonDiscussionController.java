package com.jbeli.messagerie.salonDiscussion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salonDiscussion")
@RequiredArgsConstructor
@Api(description = "chat room API having endpoints which are used to interact with messagerie microservice")
public class SalonDiscussionController {

    @Autowired
    private final SalonDiscussionRepository salonDiscussionRepository;
    @Autowired
    //private final UtilisateurClient utilisateurClient;

    private final SalonDiscussionService salonDiscussionService;

   // @PostMapping("/salon/{salonId}/utilisateur/{utilisateurId}")
   // public void ajouterUtilisateurAuSalon(@PathVariable Integer salonId, @PathVariable Integer utilisateurId) {
     //   SalonDiscussion salon = salonDiscussionRepository.findById(salonId).orElseThrow();
     //   Utilisateur utilisateur = utilisateurClient.findById(utilisateurId);
       // salon.getUtilisateurs().add(utilisateur);
        //salonDiscussionRepository.save(salon);}
    @GetMapping("/utilisateurs/{salonId}")
    public ResponseEntity<FullSalonDiscussionResponse> findAllSalonDiscussion(
            @PathVariable("salonDiscussion-id") Integer discussionId){
        return ResponseEntity.ok(salonDiscussionService.findSalonDiscussionWithUsers(discussionId));
    }

    @PostMapping
    @ApiOperation("Used to add chat room to the system")
    public ResponseEntity<Integer> save(
            @RequestBody @Valid SalonDiscussionRequest discussion
    ) {
        return ResponseEntity
                .accepted().body(salonDiscussionService.save(discussion));
    }

    @GetMapping("/{salonDiscussion-id}")
    public ResponseEntity<SalonDiscussionResponse> findById(
            @ApiParam("find the chat room by id")
            @PathVariable("salonDiscussion-id") Integer discussionId
    ) {
        return ResponseEntity.ok(salonDiscussionService.findById(discussionId));
    }

    @GetMapping
    @ApiOperation("listed all the chat rooms exist in the system")
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
    @ApiOperation("Used to find chat room by title")
    public boolean SalonDiscussionExisteParTitre(
            @ApiParam("title to find the chat room")
            @PathVariable String titre){
        return salonDiscussionService.SalonDiscussionExisteParTitre(titre);
    }

}
