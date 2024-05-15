package com.jbeli.messagerie.salonDiscussion;

import com.jbeli.messagerie.client.UtilisateurClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalonDiscussionServiceImpl implements SalonDiscussionService{

    private  SalonDiscussionRepository salonDiscussionRepository;
    private  SalonDiscussionMapper mapper ;
    private UtilisateurClient client;
    @Override
    public SalonDiscussionResponse findById(Integer id) {
        return this.salonDiscussionRepository.findById(id)
                .map(mapper::toSalonDiscussionDto)
                .orElse(new SalonDiscussionResponse());
    }

    @Override
    public List<SalonDiscussionResponse> findAll() {
        return this.salonDiscussionRepository.findAll()
                .stream()
                .map(mapper::toSalonDiscussionDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.salonDiscussionRepository.deleteById(id);

    }

    @Override
    public Integer save(SalonDiscussionRequest s) {
        SalonDiscussion salonDiscussion = mapper.toSalonDiscussion(s);
        return this.salonDiscussionRepository.save(salonDiscussion).getId();
    }

    @Override
    public boolean SalonDiscussionExisteParTitre(String titre) {
        return salonDiscussionRepository.findByTitre(titre);
    }

    @Override
    public FullSalonDiscussionResponse findSalonDiscussionWithUsers(Integer discussionId) {
        var salon = salonDiscussionRepository.findById(discussionId)
                .orElse(SalonDiscussion.builder()
                        .titre("NOT_FOUND")
                        .build()
                );
        var utilisateurss = client.findAllUsersBySalonDiscussion(discussionId);
        return FullSalonDiscussionResponse.builder()
                .titre(salon.getTitre())
                .utilisateurs(utilisateurss)
                .build();
    }
}
