package com.digiboy.erp.service;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.mapper.CompanyMapper;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.repository.CompanyRepository;
import com.digiboy.erp.to.Company;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends GeneralServiceImpl<Company, CompanyDTO> implements CompanyService {

    private final Logger logger;

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private CompanyMapper mapper;

    @Autowired
    public CompanyServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    JpaRepository<Company, Long> getRepository() {
        return repository;
    }

    @Override
    EntityMapper<Company, CompanyDTO> mapper() {
        return mapper;
    }


}
