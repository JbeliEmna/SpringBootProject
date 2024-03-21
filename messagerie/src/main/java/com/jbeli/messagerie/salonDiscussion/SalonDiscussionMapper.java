package com.jbeli.messagerie.salonDiscussion;

import com.jbeli.messagerie.messages.Messages;

import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class SalonDiscussionMapper {

    public SalonDiscussionResponse toSalonDiscussionDto(SalonDiscussion s) {
        return SalonDiscussionResponse.builder()
                .titre(s.getTitre())
                .build();
    }

    public SalonDiscussion toSalonDiscussion(SalonDiscussionRequest s) {
        return Messages.builder()
                .id(s.getId())
                .titre(s.getTitre())
                .build();
    }
}
