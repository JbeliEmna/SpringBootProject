package com.jbeli.gestion.utilisateurs.candidat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "evaluation-service")
public interface InterviewClient {
    @PostMapping("/interview/{interviewId}/candidat/{candidatId}")
    void ajouterCandidatAuInterview(@PathVariable("candidatId") Integer candidatId, @PathVariable("interviewId") Integer interviewId);

}


