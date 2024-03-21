package com.jbeli.gestion.utilisateurs.societe;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SocieteServiceImpl implements SocieteService {

    private final SocieteRepository societeRepository;
    private final SocieteMapper mapper;

    @Override
    public SocieteResponse findById(Integer id) {
        return this.societeRepository.findById(id)
                .map(mapper::toSocieteDto)
                .orElse(new SocieteResponse());
    }

    @Override
    public List<SocieteResponse> findAll() {
        return this.societeRepository.findAll()
                .stream()
                .map(mapper::toSocieteDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.societeRepository.deleteById(id);

    }

    @Override
    public Integer save(SocieteRequest u) {
        Societe societe = mapper.toSociete(u);
        return this.societeRepository.save(societe).getId();
    }

    @Override
    public boolean SocieteExisteParEmail(String email) {
        return this.societeRepository.findByEmail(email);
    }
}
