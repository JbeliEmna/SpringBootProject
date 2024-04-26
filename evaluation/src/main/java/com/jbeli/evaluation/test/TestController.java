package com.jbeli.evaluation.test;

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
@RequestMapping("/test")
@RequiredArgsConstructor
@Api(description = "Test API having endpoints which are used to interact with evaluation microservice")
public class TestController {

    private final TestService service;

    @GetMapping("/{test-id}")
    @ApiOperation("find Test by id")
    public ResponseEntity<TestResponse> findById(
            @PathVariable("test-id") Integer testId
    ) {
        return ResponseEntity.ok(service.findById(testId));
    }

    @GetMapping
    @ApiOperation("listed all the Test exist in the system")
    public ResponseEntity<List<TestResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{test-id}")
    public ResponseEntity deleteById( @ApiParam("the id of the test to be deleted") @PathVariable Integer id) {
        TestResponse test = service.findById(id);
        if (test != null) {
            service.deleteById(id);
            return ResponseEntity.ok("Test supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ApiOperation("Used to add Test to the system")
    public ResponseEntity<Integer> save( @ApiParam("Information about Test to be added to the system ")
            @RequestBody @Valid TestRequest testRequest
    ) {
        return ResponseEntity
                .accepted().body(service.save(testRequest));
    }

    @GetMapping("/existe/{test-date}")
    public boolean TestExisteParDate(@ApiParam("find test by date ") @PathVariable Date date){
        return service.TestExisteParDate(date);
    }
}

