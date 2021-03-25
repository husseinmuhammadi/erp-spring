package com.digiboy.erp.service;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.mapper.CompanyMapper;
import com.digiboy.erp.repository.CompanyRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

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
    public Page<CompanyDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::to);
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {
        return mapper.to(repository.save(mapper.from(dto)));
    }
}
