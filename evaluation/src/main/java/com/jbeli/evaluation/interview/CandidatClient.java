package com.jbeli.evaluation.interview;
import com.jbeli.gestion.utilisateurs.candidat.Candidat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "gestion-utilisateur-service")
public interface CandidatClient {


    @GetMapping("/candidat/{id}")
    static Candidat findById(@PathVariable Integer id) {
        return null;
    }
}
