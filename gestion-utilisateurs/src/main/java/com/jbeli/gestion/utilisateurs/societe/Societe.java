package com.jbeli.gestion.utilisateurs.societe;

import com.jbeli.gestion.utilisateurs.recruteur.Recruteur;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Societe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NonNull
    private String Nom;
    @Email
    private String email;
    @OneToOne(mappedBy = "societe")
    private Recruteur recruteur ;

}
