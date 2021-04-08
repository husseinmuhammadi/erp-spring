package com.digiboy.erp.web.resource;

import com.digiboy.erp.api.PayStubService;
import com.digiboy.erp.dto.PayStubDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RequestMapping("/api/v1/paystubs")
@RestController
public class PayStubResource {

    @Autowired
    private PayStubService service;

    @GetMapping
    public ResponseEntity<List<PayStubDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }
}
