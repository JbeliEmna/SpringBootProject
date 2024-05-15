package com.jbeli.messagerie.salonDiscussion;

import lombok.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSalonDiscussionResponse {

    private String titre;
    List<Utilisateur> utilisateurs;
}
