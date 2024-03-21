package com.jbeli.messagerie.salonDiscussion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SalonDiscussionResponse {

    @Column(nullable = false)
    @NotBlank
    private String titre;
}
