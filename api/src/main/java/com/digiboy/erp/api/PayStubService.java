package com.digiboy.erp.api;

import com.digiboy.erp.dto.EmployeeDTO;
import com.digiboy.erp.dto.PayStubDTO;

import java.util.List;
import java.util.Optional;

public interface PayStubService extends GeneralService<PayStubDTO> {
    List<String> findAllHeadings();

    Optional<PayStubDTO> findByEmployeeAndPayDate(EmployeeDTO employee, String payDate);

    List<String> findAllIssueYears(EmployeeDTO employee);
}
