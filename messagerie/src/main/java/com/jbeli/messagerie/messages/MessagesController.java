package com.jbeli.messagerie.messages;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessagesController {

   private final MessagesService messagesService;

    @PostMapping
    public ResponseEntity<Integer> save(
            @RequestBody @Valid MessagesRequest message
    ) {
        return ResponseEntity
                .accepted().body(messagesService.save(message));
    }

    @GetMapping("/{message-id}")
    public ResponseEntity<MessagesResponse> findById(
            @PathVariable("message-id") Integer MessageId
    ) {
        return ResponseEntity.ok(messagesService.findById(MessageId));
    }

    @GetMapping
    public ResponseEntity<List<MessagesResponse>> findAll() {
        return ResponseEntity.ok(messagesService.findAll());
    }
    @DeleteMapping("/{message-id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        MessagesResponse message= messagesService.findById(id);
        if (message != null) {
            messagesService.deleteById(id);
            return ResponseEntity.ok("Message supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/existe_par_Etat/{message-etat}")
    public boolean MessageExisteParEtat( @PathVariable EtatEnum etat){
        return messagesService.MessageExisteParEtat(etat);
    }

    @GetMapping("/existe_par_date/{message-date}")
    public boolean MessageExisteParDate( @PathVariable Date date){
        return messagesService.MessageExisteParDate(date);
    }
}
