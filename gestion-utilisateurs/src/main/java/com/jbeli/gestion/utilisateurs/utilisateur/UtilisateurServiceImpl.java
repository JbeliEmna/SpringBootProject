package com.jbeli.gestion.utilisateurs.utilisateur;


import com.jbeli.gestion.utilisateurs.common.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository repository;
    private final UtilisateurMapper mapper;

    @Override
    public UtilisateurResponse findById(Integer id) {

        return this.repository.findById(id)
                .map(mapper::toUtilisateurDto)
                .orElse(new UtilisateurResponse());
    }

    @Override
    public PageResponse<UtilisateurResponse> findAll(int page, int size) {
        var pageResult = this.repository.findAll(PageRequest.of(page, size));
        return PageResponse.<UtilisateurResponse>builder()
                .content(
                        pageResult.getContent()
                                .stream()
                                .map(mapper::toUtilisateurDto)
                                .toList()
                )
                .totalPages(pageResult.getTotalPages())
                .build();
    }


    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);

    }

    @Override
    public Integer save(UtilisateurRequest u) {
        Utilisateur utilisateur = mapper.toUtilisateur(u);
        return this.repository.save(utilisateur).getId();
    }

    @Override
    public boolean utilisateurExisteParEmail(String email) {

        return repository.findByEmail(email);
    }

    @Override
    public boolean utilisateurExisteParNumTel(String numTelephone) {
        return repository.findBynumTelephone(numTelephone);
    }

    @Override
    public void changerMotDePasse(Integer id, String nouveauMotDePasse) {
        Utilisateur utilisateur = repository.findById(id).orElse(null);
        if (utilisateur != null) {
            utilisateur.setMotDePasse(nouveauMotDePasse);
            repository.save(utilisateur);
        }
    }




}
