package com.jbeli.evaluation.interview;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/interview")
@RequiredArgsConstructor
@Api(description = "Interview API having endpoints which are used to interact with evaluation microservice")
public class InterviewController {

    private final InterviewService service;


    @GetMapping("/{interview-id}")
    @ApiOperation("find Interview by id")
    public ResponseEntity<InterviewResponse> findById(
            @PathVariable("interview-id") Integer interviewId
    ) {
        return ResponseEntity.ok(service.findById(interviewId));
    }

    @GetMapping
    @ApiOperation("listed all the Interview exist in the system")
    public ResponseEntity<List<InterviewResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @DeleteMapping("/{interview-id}")
    public ResponseEntity deleteById( @ApiParam("the id of the Interview to be deleted") @PathVariable Integer id) {
        InterviewResponse interview = service.findById(id);
        if (interview != null) {
            service.deleteById(id);
            return ResponseEntity.ok("Interview supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ApiOperation("Used to add Interview to the system")
    public ResponseEntity<Integer> save(
            @ApiParam("Information about Interview to be added to the system ")
            @RequestBody @Valid InterviewRequest interviewRequest
    ) {
        return ResponseEntity
                .accepted().body(service.save(interviewRequest));
    }

    @GetMapping("/existe/{interview-DateDebut}")
    public boolean interviewExisteParDateDebut( @ApiParam("find the interview by start date ") @PathVariable Date dateDebut){
        return service.interviewExisteParDateDebut(dateDebut);
    }

    @GetMapping("/existe/{interview-DateFin}")
    public boolean interviewExisteParDateFin( @ApiParam("find the interview by end date ") @PathVariable Date dateFin){
        return service.interviewExisteParDateFin(dateFin);
    }



}
