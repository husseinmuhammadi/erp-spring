package com.digiboy.erp.web.resource;

import com.digiboy.erp.api.EmployeeService;
import com.digiboy.erp.api.PayStubItemService;
import com.digiboy.erp.api.PayStubService;
import com.digiboy.erp.api.UserService;
import com.digiboy.erp.dto.DeductionPayStubItemDTO;
import com.digiboy.erp.dto.EarningPayStubItemDTO;
import com.digiboy.erp.dto.EmployeeDTO;
import com.digiboy.erp.dto.PayStubDTO;
import com.digiboy.erp.web.admin.AdminPayStub;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@CrossOrigin
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

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    public PayStubResource(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/{yyyy}/{mm}")
    public ResponseEntity<Optional<PayStubDTO>> findByPayDate(@PathVariable("yyyy") String year, @PathVariable("mm") String month) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
        }
        logger.info("------>{}", authentication.getPrincipal().getClass().getName());
        if (!(authentication.getPrincipal() instanceof UserDetails))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        EmployeeDTO employee = employeeService.findEmployeeByCode(userDetails.getUsername());
        Optional<PayStubDTO> payStubDTO = service.findByEmployeeAndPayDate(employee, year + month);
        return ResponseEntity.ok(payStubDTO);
    }

    @GetMapping("/issue-years")
    public ResponseEntity<List<String>> findAllByIssueYears() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
        }
        logger.info("------>{}", authentication.getPrincipal().getClass().getName());
        if (!(authentication.getPrincipal() instanceof UserDetails))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        EmployeeDTO employee = employeeService.findEmployeeByCode(userDetails.getUsername());
        List<String> issueYears = service.findAllIssueYears(employee);
        return ResponseEntity.ok(issueYears);
    }

    @GetMapping
    public ResponseEntity<List<PayStubDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PayStubDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PayStubDTO> save(@RequestBody PayStubDTO payStubDTO) {
        return ResponseEntity.ok(service.save(payStubDTO));
    }

    @GetMapping("/headings")
    public ResponseEntity<List<String>> activePayStubs() {
        return ResponseEntity.ok(service.findAllHeadings());
    }

    @PostMapping("/test")
    public ResponseEntity<PayStubDTO> save(@RequestParam("payPeriod") Optional<String> payPeriod) {
        PayStubDTO payStubDTO = new PayStubDTO();
        payStubDTO.setEmployeeName(adminPayStub.getEmployeeName());
        payStubDTO.setEmployeeCode(adminPayStub.getEmployeeCode());
        payStubDTO.setPayPeriod(payPeriod.orElse("------"));
        payStubDTO.setPayDate(payPeriod.orElse("140001"));

        DeductionPayStubItemDTO deductionRound = new DeductionPayStubItemDTO();
        deductionRound.setAmount(adminPayStub.getDeductionRoundAmount());
        deductionRound.setTitle(adminPayStub.getDeductionRoundTitle());

        DeductionPayStubItemDTO deductionInsurance = new DeductionPayStubItemDTO();
        deductionInsurance.setAmount(adminPayStub.getDeductionInsuranceAmount());
        deductionInsurance.setTitle(adminPayStub.getDeductionInsuranceTitle());

        DeductionPayStubItemDTO deductionTax = new DeductionPayStubItemDTO();
        deductionTax.setAmount(adminPayStub.getDeductionTaxAmount());
        deductionTax.setTitle(adminPayStub.getDeductionTaxTitle());

        DeductionPayStubItemDTO deductionInsuranceComplementary = new DeductionPayStubItemDTO();
        deductionInsuranceComplementary.setAmount(adminPayStub.getDeductionInsuranceComplementaryAmount());
        deductionInsuranceComplementary.setTitle(adminPayStub.getDeductionInsuranceComplementaryTitle());

        DeductionPayStubItemDTO deductionHelp = new DeductionPayStubItemDTO();
        deductionHelp.setAmount(adminPayStub.getDeductionHelpAmount());
        deductionHelp.setTitle(adminPayStub.getDeductionHelpTitle());

        payStubDTO.setDeductions(new HashSet<>());
        payStubDTO.getDeductions().add(deductionRound);
        payStubDTO.getDeductions().add(deductionInsurance);
        payStubDTO.getDeductions().add(deductionTax);
        payStubDTO.getDeductions().add(deductionInsuranceComplementary);
        payStubDTO.getDeductions().add(deductionHelp);

        EarningPayStubItemDTO earningOverTime = new EarningPayStubItemDTO();
        earningOverTime.setAmount(adminPayStub.getEarningOverTimeAmount());
        earningOverTime.setTitle(adminPayStub.getEarningOverTimeTitle());

        payStubDTO.setEarnings(new HashSet<>());
        payStubDTO.getEarnings().add(earningOverTime);

        PayStubDTO payStubDTO1 = service.save(payStubDTO);

        return ResponseEntity.ok(payStubDTO1);
    }
}
