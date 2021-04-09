package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.to.Company;
import org.mapstruct.Mapper;

@Mapper(uses = {EmployeeMapper.class})
public interface CompanyMapper extends EntityMapper<Company, CompanyDTO> {
}
