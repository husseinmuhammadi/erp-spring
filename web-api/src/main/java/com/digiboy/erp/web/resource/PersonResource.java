package com.digiboy.erp.web.resource;

import com.digiboy.erp.api.PersonService;
import com.digiboy.erp.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/people")
@RestController
public class PersonResource {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO) {
        service.save(personDTO);
        return ResponseEntity.ok(personDTO);
    }
}
