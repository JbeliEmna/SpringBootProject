package com.jbeli.messagerie.reclamation;

import com.jbeli.messagerie.messages.Messages;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ApiModel("Contains all the attributes required under claims entity")
public class Reclamation extends Messages {


    @ApiModelProperty("the subject of the claim")
    private String sujet;

}
