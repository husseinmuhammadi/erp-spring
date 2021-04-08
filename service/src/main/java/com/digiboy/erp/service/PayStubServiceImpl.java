package com.digiboy.erp.service;

import com.digiboy.erp.api.PayStubService;
import com.digiboy.erp.dto.PayStubDTO;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.mapper.PayStubMapper;
import com.digiboy.erp.repository.PayStubRepository;
import com.digiboy.erp.to.PayStub;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PayStubServiceImpl extends GeneralServiceImpl<PayStub, PayStubDTO> implements PayStubService {

    @Autowired
    PayStubRepository repository;

    @Autowired
    PayStubMapper mapper;

    @Autowired
    public PayStubServiceImpl(Logger logger) {
        super(logger);
    }

    @Override
    JpaRepository<PayStub, Long> getRepository() {
        return repository;
    }

    @Override
    EntityMapper<PayStub, PayStubDTO> mapper() {
        return mapper;
    }
}
