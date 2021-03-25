package com.digiboy.erp.service;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.mapper.CompanyMapper;
import com.digiboy.erp.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private CompanyMapper mapper;

    @Override
    public Page<CompanyDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::to);
    }
}
