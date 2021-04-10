package com.digiboy.erp.web.resource;

import com.digiboy.erp.api.UserService;
import com.digiboy.erp.dto.UserDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SignUpResource {

    private final Logger logger;

    @Autowired
    private UserService userService;

    public SignUpResource(Logger logger) {
        this.logger = logger;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.save(userDTO));
    }
}
