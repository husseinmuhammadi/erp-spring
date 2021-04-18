package com.digiboy.erp.service;

import com.digiboy.erp.api.PayStubItemService;
import com.digiboy.erp.dto.DeductionPayStubItemDTO;
import com.digiboy.erp.dto.PayStubItemDTO;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.mapper.PayStubItemMapper;
import com.digiboy.erp.repository.DeductionPayStubItemRepository;
import com.digiboy.erp.repository.PayStubItemRepository;
import com.digiboy.erp.to.PayStubItem;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayStubItemServiceImpl extends GeneralServiceImpl<PayStubItem, PayStubItemDTO> implements PayStubItemService {

    @Autowired
    PayStubItemRepository repository;

    @Autowired
    DeductionPayStubItemRepository deductionPayStubItemRepository;

    @Autowired
    PayStubItemMapper mapper;

    @Autowired
    public PayStubItemServiceImpl(Logger logger) {
        super(logger);
    }

    @Override
    JpaRepository<PayStubItem, Long> getRepository() {
        return repository;
    }

    @Override
    EntityMapper<PayStubItem, PayStubItemDTO> mapper() {
        return mapper;
    }
}
