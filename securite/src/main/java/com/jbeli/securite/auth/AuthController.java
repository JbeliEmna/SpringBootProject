package com.jbeli.securite.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
//@Tag(name = "Authentication")
@Api(description = "Authentication API having endpoints which are used to interact with securite microservice")
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    @ApiOperation("used to register user to the system ")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> register(
            @ApiParam("request to register the user")
            @RequestBody @Valid RegisterRequest request
    ) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }


    @PostMapping("/login")
    @ApiOperation("used to login to the system by user")
    public ResponseEntity<AuthResponse> authenticate(
            @ApiParam("authRequest to authenticate the user")
            @RequestBody @Valid AuthRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/activate-account")
    @ApiOperation("used to activate the account")
    public void confirm(@RequestParam String token) throws MessagingException {
        service.activateAccount(token);
    }


}

