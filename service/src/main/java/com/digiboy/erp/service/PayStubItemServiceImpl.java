package com.digiboy.erp.service;

import com.digiboy.erp.api.PayStubItemService;
import com.digiboy.erp.api.PersonService;
import com.digiboy.erp.dto.PayStubItemDTO;
import com.digiboy.erp.dto.PersonDTO;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.mapper.PayStubItemMapper;
import com.digiboy.erp.mapper.PersonMapper;
import com.digiboy.erp.repository.PayStubItemRepository;
import com.digiboy.erp.repository.PersonRepository;
import com.digiboy.erp.to.DeductionPayStubItem;
import com.digiboy.erp.to.PayStubItem;
import com.digiboy.erp.to.Person;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PayStubItemServiceImpl extends GeneralServiceImpl<DeductionPayStubItem, PayStubItemDTO> implements PayStubItemService {

    @Autowired
    PayStubItemRepository repository;

    @Autowired
    PayStubItemMapper mapper;

    @Autowired
    public PayStubItemServiceImpl(Logger logger) {
        super(logger);
    }

    @Override
    JpaRepository<DeductionPayStubItem, Long> getRepository() {
        return repository;
    }

    @Override
    EntityMapper<DeductionPayStubItem, PayStubItemDTO> mapper() {
        return mapper;
    }
}
