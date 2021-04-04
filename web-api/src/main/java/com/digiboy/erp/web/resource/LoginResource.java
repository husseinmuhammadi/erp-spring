package com.digiboy.erp.web.resource;

import com.digiboy.erp.web.security.Credential;
import com.digiboy.erp.web.security.Token;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResource {

    private final Logger logger;

    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginResource(Logger logger) {
        this.logger = logger;
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Credential credential) {
        logger.info("Login started");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword()));
        return ResponseEntity.ok(new Token());
    }
}
