package com.digiboy.erp.web.resource;

import com.digiboy.erp.web.security.Credential;
import com.digiboy.erp.web.security.JwtTokenUtil;
import com.digiboy.erp.web.security.Token;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginResource {

    private final Logger logger;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public LoginResource(Logger logger) {
        this.logger = logger;
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Credential credential) {
        logger.info("Login started");

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword()));
        } catch (DisabledException e) {
            throw e;
        } catch (BadCredentialsException e) {
            throw e;
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("{}", auth.getPrincipal());
        UserDetails userDetails = userDetailsService.loadUserByUsername(credential.getUsername());
        return ResponseEntity.ok(new Token(jwtTokenUtil.generateToken(userDetails)));
    }
}
