package com.jbeli.evaluation.interview;


import com.jbeli.evaluation.test.Test;
import com.jbeli.gestion.utilisateurs.candidat.Candidat;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private Date dateDebut;

    private Date dateFin;

    @OneToMany(mappedBy = "interview",  orphanRemoval = true)
    private List<Test> tests = new ArrayList<>();

    @Getter
    private List<Candidat> candidats;

    public List<Candidat> getCandidat() {
        return candidats;
    }



}
