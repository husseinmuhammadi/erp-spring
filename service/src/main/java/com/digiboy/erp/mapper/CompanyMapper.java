package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.to.Company;
import org.mapstruct.Mapper;

import javax.persistence.Converter;

@Mapper
public interface CompanyMapper extends EntityMapper<Company, CompanyDTO> {

    CompanyDTO from(Company company);

    Company to(CompanyDTO companyDTO);
}
