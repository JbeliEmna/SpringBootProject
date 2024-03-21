package com.jbeli.evaluation.interview;

import com.jbeli.gestion.utilisateurs.utilisateur.Utilisateur;
import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService{

    private final InterviewRepository repository;
    private final InterviewMapper mapper;


    @Override
    public InterviewResponse findById(Integer id) {

        return this.repository.findById(id)
                .map(mapper::toInterviewDto)
                .orElse(new InterviewResponse());
    }

    @Override
    public List<InterviewResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::toInterviewDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);

    }

    @Override
    public Integer save(InterviewRequest i) {
        Interview interview = mapper.toInterview(i);
        return this.repository.save(interview).getId();
    }

    @Override
    public boolean interviewExisteParDateDebut(Date dateDebut) {

        return repository.findByDateDebut(dateDebut);
    }

    @Override
    public boolean interviewExisteParDateFin(Date dateFin) {
        return repository.findByDateFin(dateFin);
    }
}
