package com.jbeli.evaluation.pieceJointe;

import com.jbeli.evaluation.interview.Interview;
import com.jbeli.evaluation.interview.InterviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PieceJointeServiceImpl implements PieceJointeService{
    private final PieceJointeRepository repository;
    private final PieceJointeMapper mapper;

    @Override
    public PieceJointeResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(mapper::toPieceJointeDto)
                .orElse(new PieceJointeResponse());
    }

    @Override
    public List<PieceJointeResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::toPieceJointeDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);

    }

    @Override
    public Integer save(PieceJointeRequest p) {
        PieceJointe pieceJointe = mapper.toInterview(p);
        return this.repository.save(pieceJointe).getId();
    }

    @Override
    public boolean PieceJointeExisteParSujet(String sujet) {

        return repository.PieceJointeExisteParSujet(sujet);
    }
}
