package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.to.Company;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    Company from(CompanyDTO companyDTO);

    CompanyDTO to(Company company);
}
