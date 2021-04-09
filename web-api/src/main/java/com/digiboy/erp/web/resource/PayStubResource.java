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

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

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
        PayStubDTO payStubDTO1 = service.save(payStubDTO);

        DeductionPayStubItemDTO deductionPayStubItemDTO = new DeductionPayStubItemDTO();
        deductionPayStubItemDTO.setAmount(1000L);
        deductionPayStubItemDTO.setTitle("deduction1");
        deductionPayStubItemDTO.setPayStub(payStubDTO1);
        payStubItemService.save(deductionPayStubItemDTO);

        // payStubDTO.setDeductions(Arrays.asList(deductionPayStubItemDTO));

        return ResponseEntity.ok(payStubDTO1);
    }
}
