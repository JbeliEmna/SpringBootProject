package com.jbeli.evaluation.pieceJointe;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pieceJointe")
@RequiredArgsConstructor
public class PieceJointeController {

    private final PieceJointeService service;


    @GetMapping("/{pieceJointe-id}")
    public ResponseEntity<PieceJointeResponse> findById(
            @PathVariable("pieceJointe-id") Integer pieceJointeId
    ) {
        return ResponseEntity.ok(service.findById(pieceJointeId));
    }

    @GetMapping
    public ResponseEntity<List<PieceJointeResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{pieceJointe-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        PieceJointeResponse pieceJointe = service.findById(id);
        if (pieceJointe != null) {
            service.deleteById(id);
            return ResponseEntity.ok("Piece Jointe supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> save(
            @RequestBody @Valid PieceJointeRequest pieceJointeRequest
    ) {
        return ResponseEntity
                .accepted().body(service.save(pieceJointeRequest));
    }

    @GetMapping("/existe/{interview-DateFin}")
    public boolean PieceJointeExisteParSujet(@PathVariable String sujet){
        return service.PieceJointeExisteParSujet(sujet);
    }
}
