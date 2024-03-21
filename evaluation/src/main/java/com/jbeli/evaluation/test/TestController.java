package com.jbeli.evaluation.test;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @GetMapping("/{test-id}")
    public ResponseEntity<TestResponse> findById(
            @PathVariable("test-id") Integer testId
    ) {
        return ResponseEntity.ok(service.findById(testId));
    }

    @GetMapping
    public ResponseEntity<List<TestResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{test-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        TestResponse test = service.findById(id);
        if (test != null) {
            service.deleteById(id);
            return ResponseEntity.ok("Test supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> save(
            @RequestBody @Valid TestRequest testRequest
    ) {
        return ResponseEntity
                .accepted().body(service.save(testRequest));
    }

    @GetMapping("/existe/{test-date}")
    public boolean TestExisteParDate(@PathVariable Date date){
        return service.TestExisteParDate(date);
    }
}

