package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.EmployeeDTO;
import com.digiboy.erp.to.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeDTO> {
}
