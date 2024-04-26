package com.jbeli.messagerie.messages;


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
@RequestMapping("/messages")
@RequiredArgsConstructor
@Api(description = "Messages API having endpoints which are used to interact with messagerie microservice")
public class MessagesController {

   private final MessagesService messagesService;

    @PostMapping
    @ApiOperation("Used to add message to the system")
    public ResponseEntity<Integer> save(
            @RequestBody @Valid MessagesRequest message
    ) {
        return ResponseEntity
                .accepted().body(messagesService.save(message));
    }

    @GetMapping("/{message-id}")
    public ResponseEntity<MessagesResponse> findById(
            @ApiParam("find the message by id")
            @PathVariable("message-id") Integer MessageId
    ) {
        return ResponseEntity.ok(messagesService.findById(MessageId));
    }

    @GetMapping
    @ApiOperation("listed all the messages exist in the system")
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
    @ApiOperation("Used to find message by status")
    public boolean MessageExisteParEtat(
            @ApiParam("status to find the message")
            @PathVariable EtatEnum etat){
        return messagesService.MessageExisteParEtat(etat);
    }

    @GetMapping("/existe_par_date/{message-date}")
    @ApiOperation("Used to find message by date")
    public boolean MessageExisteParDate(
            @ApiParam("date to find the message")
            @PathVariable Date date){
        return messagesService.MessageExisteParDate(date);
    }
}
