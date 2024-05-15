package com.jbeli.gestion.utilisateurs.utilisateur;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@ApiModel("Contains all the attributes required under User entity")
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @ApiModelProperty("name of the user")
    private String nom;

    @ApiModelProperty("email of the user")
    private String email;

    @ApiModelProperty("password of the user")
    private String motDePasse;

    @ApiModelProperty("phone number of the user")
    private String numTelephone;

    @ApiModelProperty("geographic data of the user")
    private String donneesGeo;

    private Integer SalonDiscussionId;

   // @ManyToMany
    //@JoinTable(name = "utilisateur_SalonDiscussion",
      //      joinColumns = @JoinColumn(name = "utilisateur_id"),
        //    inverseJoinColumns = @JoinColumn(name = "SalonDiscussion_id"))
    //private Set<SalonDiscussion> salonDiscussions = new HashSet<>();

    //@OneToMany(mappedBy = "utilisateur")
    //private List<UtilisateurSalonDiscussion> utilisateurSalonDiscussions;


}
