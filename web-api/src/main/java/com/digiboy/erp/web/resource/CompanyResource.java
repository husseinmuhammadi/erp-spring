package com.digiboy.erp.web.resource;


import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/v1/companies")
@RestController
public class CompanyResource {

    private final Logger logger;

    @Autowired
    private CompanyService service;

    public CompanyResource(Logger logger) {
        this.logger = logger;
    }


    @GetMapping
    public ResponseEntity<List<CompanyDTO>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> save(@RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok(service.save(companyDTO));
    }

    @PostMapping("/test")
    public ResponseEntity<CompanyDTO> save() {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName("test");

        EmployeeDTO employee1 = new EmployeeDTO();
        employee1.setEmployeeCode("10000001");
        employee1.setCompany(companyDTO);

        EmployeeDTO employee2 = new EmployeeDTO();
        employee2.setEmployeeCode("10000002");
        employee2.setCompany(companyDTO);

//        companyDTO.setEmployees(Arrays.asList(employee1, employee2));
        return ResponseEntity.ok(service.save(companyDTO));
    }
}
