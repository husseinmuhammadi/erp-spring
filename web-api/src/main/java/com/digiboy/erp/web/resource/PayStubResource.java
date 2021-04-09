package com.digiboy.erp.web.resource;

import com.digiboy.erp.api.PayStubService;
import com.digiboy.erp.dto.DeductionPayStubItemDTO;
import com.digiboy.erp.dto.PayStubDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @PostMapping
    public ResponseEntity<PayStubDTO> save(@RequestBody PayStubDTO payStubDTO) {
        return ResponseEntity.ok(service.save(payStubDTO));
    }

    @PostMapping("/save")
    public ResponseEntity<PayStubDTO> save() {
        PayStubDTO payStubDTO = new PayStubDTO();
        payStubDTO.setEmployeeName("Ali");
        payStubDTO.setEmployeeCode("100001");
        payStubDTO.setPayPeriod("1399102");

        DeductionPayStubItemDTO deductionPayStubItemDTO = new DeductionPayStubItemDTO();
        deductionPayStubItemDTO.setAmount(1000L);
        deductionPayStubItemDTO.setTitle("deduction1");

        payStubDTO.setDeductions(Arrays.asList(deductionPayStubItemDTO));
        return ResponseEntity.ok(service.save(payStubDTO));
    }
}
