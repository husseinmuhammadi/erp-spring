package com.digiboy.erp.api;

import com.digiboy.erp.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService extends GeneralService<EmployeeDTO> {

    EmployeeDTO findEmployeeByCode(String code);

    List<EmployeeDTO> fetchAll();
}
