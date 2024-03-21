package com.jbeli.messagerie.reclamation;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reclamation")
@RequiredArgsConstructor
public class ReclamationController {

    private final ReclamationService reclamationService;

    @GetMapping("/existe_par_Etat/{reclamation-etat}")
    public boolean ReclamationExisteParSujet( @PathVariable String sujet){
        return reclamationService.ReclamationExisteParSujet(sujet);
    }
}
