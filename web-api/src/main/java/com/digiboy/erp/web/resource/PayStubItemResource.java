package com.digiboy.erp.web.resource;

import com.digiboy.erp.api.PayStubItemService;
import com.digiboy.erp.dto.DeductionPayStubItemDTO;
import com.digiboy.erp.dto.EarningPayStubItemDTO;
import com.digiboy.erp.dto.PayStubItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/paystubitems")
@RestController
public class PayStubItemResource {

    @Autowired
    private PayStubItemService service;

    @GetMapping
    public ResponseEntity<List<PayStubItemDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<PayStubItemDTO> save(@RequestBody PayStubItemDTO payStubItemDTO) {
        return ResponseEntity.ok(service.save(payStubItemDTO));
    }

    @PostMapping("/deductions")
    public ResponseEntity<PayStubItemDTO> save(@RequestBody DeductionPayStubItemDTO payStubItemDTO) {
        return ResponseEntity.ok(service.save(payStubItemDTO));
    }

    @PostMapping("/earnings")
    public ResponseEntity<PayStubItemDTO> save(@RequestBody EarningPayStubItemDTO payStubItemDTO) {
        return ResponseEntity.ok(service.save(payStubItemDTO));
    }
}
