package com.digiboy.erp.api;

import com.digiboy.erp.dto.EmployeeDTO;

public interface EmployeeService extends GeneralService<EmployeeDTO> {
    EmployeeDTO findEmployeeByCode(String code);
}
