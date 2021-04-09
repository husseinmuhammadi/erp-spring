package com.digiboy.erp.web.resource;

import com.digiboy.erp.api.PayStubItemService;
import com.digiboy.erp.api.PayStubService;
import com.digiboy.erp.dto.DeductionPayStubItemDTO;
import com.digiboy.erp.dto.PayStubDTO;
import com.digiboy.erp.web.admin.AdminPayStub;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api/v1/paystubs")
@RestController
public class PayStubResource {

    private final Logger logger;

    @Autowired
    private PayStubService service;

    @Autowired
    private PayStubItemService payStubItemService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AdminPayStub adminPayStub;

    public PayStubResource(Logger logger) {
        this.logger = logger;
    }

    @GetMapping
    public ResponseEntity<List<PayStubDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PayStubDTO>> list(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PayStubDTO> save(@RequestBody PayStubDTO payStubDTO) {
        return ResponseEntity.ok(service.save(payStubDTO));
    }

    @PostMapping("/test")
    public ResponseEntity<PayStubDTO> save(@RequestParam("payPeriod") Optional<String> payPeriod) {
        PayStubDTO payStubDTO = new PayStubDTO();
        payStubDTO.setEmployeeName(adminPayStub.getEmployeeName());
        payStubDTO.setEmployeeCode(adminPayStub.getEmployeeCode());
        payStubDTO.setPayPeriod(payPeriod.orElse("------"));

        DeductionPayStubItemDTO deductionPayStubItemDTO1 = new DeductionPayStubItemDTO();
        deductionPayStubItemDTO1.setAmount(1000L);
        deductionPayStubItemDTO1.setTitle("deduction1");

        DeductionPayStubItemDTO deductionPayStubItemDTO2 = new DeductionPayStubItemDTO();
        deductionPayStubItemDTO2.setAmount(1000L);
        deductionPayStubItemDTO2.setTitle("deduction1");

        payStubDTO.setDeductions(new HashSet<>());
        payStubDTO.getDeductions().add(deductionPayStubItemDTO1);
        payStubDTO.getDeductions().add(deductionPayStubItemDTO2);

        PayStubDTO payStubDTO1 = service.save(payStubDTO);

        return ResponseEntity.ok(payStubDTO1);
    }
}
