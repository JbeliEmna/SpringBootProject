package com.jbeli.gestion.utilisateurs.OffreEmploi;


import java.util.List;

public interface OffreEmploiService {
    OffreEmlpoiResponse findById(Integer id);
    List<OffreEmlpoiResponse> findAll();

    void deleteById(Integer id);

    Integer save(OffreEmlpoiRequest offre);

    void changerDescription(Integer id, String Description);
}
