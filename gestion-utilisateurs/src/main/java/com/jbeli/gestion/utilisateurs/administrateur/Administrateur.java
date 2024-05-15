package com.jbeli.gestion.utilisateurs.administrateur;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import io.swagger.annotations.ApiModel;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter


@Entity
@ApiModel("Contains all the attributes required under Admin entity")
public class Administrateur extends Utilisateur {
}
