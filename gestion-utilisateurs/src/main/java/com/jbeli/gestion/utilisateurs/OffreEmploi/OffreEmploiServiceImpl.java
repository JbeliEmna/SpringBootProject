package com.jbeli.gestion.utilisateurs.OffreEmploi;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OffreEmploiServiceImpl implements OffreEmploiService{

    private final OffreEmploiRepository repository;
    private final OffreEmploMapper mapper;

    @Override
    public OffreEmlpoiResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(mapper::toOffreEmploiDto)
                .orElse(new OffreEmlpoiResponse());
    }

    @Override
    public List<OffreEmlpoiResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::toOffreEmploiDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id){
        this.repository.deleteById(id);
    }

    @Override
    public Integer save(OffreEmlpoiRequest offre) {
            OffreEmploi offreEmploi = mapper.toOffreEmlpoi(offre);
            return this.repository.save(offreEmploi).getId();
    }

    @Override
    public void changerDescription(Integer id, String Description) {
        OffreEmploi offreEmploi = repository.findById(id).orElse(null);
        if (offreEmploi  != null) {
            offreEmploi .setDescription(Description);
            repository.save(offreEmploi );
        }

    }
}
