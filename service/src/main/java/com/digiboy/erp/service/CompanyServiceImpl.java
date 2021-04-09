package com.digiboy.erp.service;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.mapper.CompanyMapper;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.repository.CompanyRepository;
import com.digiboy.erp.repository.EntityStateHistoryRepository;
import com.digiboy.erp.to.Company;
import com.digiboy.erp.to.EntityStateHistory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompanyServiceImpl extends GeneralServiceImpl<Company, CompanyDTO> implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private EntityStateHistoryRepository entityStateHistoryRepository;

    @Autowired
    private CompanyMapper mapper;

    @Autowired
    public CompanyServiceImpl(Logger logger) {
        super(logger);
    }

    @Override
    JpaRepository<Company, Long> getRepository() {
        return repository;
    }

    @Override
    EntityMapper<Company, CompanyDTO> mapper() {
        return mapper;
    }

//    @Override
//    public CompanyDTO save(CompanyDTO companyDTO) {
//        Company company = mapper.map(companyDTO);
//
//        repository.save(company);
//
//        if (companyDTO.getName().startsWith("E"))
//            throw new RuntimeException();
//
//        EntityStateHistory entityStateHistory = new EntityStateHistory();
//        entityStateHistory.setState("E");
//        entityStateHistory.setEntity(company);
//        entityStateHistoryRepository.save(entityStateHistory);
//
//        return companyDTO;
//    }
}
