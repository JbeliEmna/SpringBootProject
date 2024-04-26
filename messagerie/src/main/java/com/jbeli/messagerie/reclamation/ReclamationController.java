package com.jbeli.messagerie.reclamation;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reclamation")
@RequiredArgsConstructor
@Api(description = "claim API having endpoints which are used to interact with messagerie microservice")
public class ReclamationController {

    private final ReclamationService reclamationService;

    @GetMapping("/existe_par_Etat/{reclamation-etat}")
    @ApiOperation("Used to find claim by subject")
    public boolean ReclamationExisteParSujet(
            @ApiParam("subject to find the claim")
            @PathVariable String sujet){
        return reclamationService.ReclamationExisteParSujet(sujet);
    }
}
