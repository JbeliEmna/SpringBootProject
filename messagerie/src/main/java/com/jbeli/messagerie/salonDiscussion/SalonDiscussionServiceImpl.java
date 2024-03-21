package com.jbeli.messagerie.salonDiscussion;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@RequiredArgsConstructor
public class SalonDiscussionServiceImpl implements SalonDiscussionService{

    private final SalonDiscussionRepository salonDiscussionRepository;
    private final SalonDiscussionMapper mapper ;
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
}
