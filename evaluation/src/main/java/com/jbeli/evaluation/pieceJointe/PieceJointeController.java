package com.jbeli.evaluation.pieceJointe;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pieceJointe")
@RequiredArgsConstructor
@Api(description = "Attachment API having endpoints which are used to interact with evaluation microservice")
public class PieceJointeController {

    private final PieceJointeService service;


    @GetMapping("/{pieceJointe-id}")
    @ApiOperation("find Attachment by id")
    public ResponseEntity<PieceJointeResponse> findById(
            @PathVariable("pieceJointe-id") Integer pieceJointeId
    ) {
        return ResponseEntity.ok(service.findById(pieceJointeId));
    }

    @GetMapping
    @ApiOperation("listed all the Attachment exist in the system")
    public ResponseEntity<List<PieceJointeResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{pieceJointe-id}")
    public ResponseEntity deleteById(@ApiParam("the id of the Attachment to be deleted") @PathVariable Integer id) {
        PieceJointeResponse pieceJointe = service.findById(id);
        if (pieceJointe != null) {
            service.deleteById(id);
            return ResponseEntity.ok("Piece Jointe supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ApiOperation("Used to add Attachment to the system")
    public ResponseEntity<Integer> save(
            @ApiParam("Information about Attachment to be added to the system ")
            @RequestBody @Valid PieceJointeRequest pieceJointeRequest
    ) {
        return ResponseEntity
                .accepted().body(service.save(pieceJointeRequest));
    }

    @GetMapping("/existe/{interview-DateFin}")
    public boolean PieceJointeExisteParSujet( @ApiParam("find Attachment by subject ") @PathVariable String sujet){
        return service.PieceJointeExisteParSujet(sujet);
    }
}
