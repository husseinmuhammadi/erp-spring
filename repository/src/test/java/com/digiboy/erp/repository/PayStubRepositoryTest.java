package com.digiboy.erp.repository;

import com.digiboy.erp.to.DeductionPayStubItem;
import com.digiboy.erp.to.PayStub;
import com.digiboy.erp.to.PayStubItem;
import com.digiboy.erp.utils.JsonUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PayStubRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(PayStubRepositoryTest.class);

    @Autowired
    private PayStubRepository payStubRepository;

    @Autowired
    private PayStubItemRepository payStubItemRepository;

    @Test
    void savePayStub() {
        PayStub payStub = new PayStub();
        payStub.setDeductions(Arrays.asList(new DeductionPayStubItem()));
        PayStub payStub1 = payStubRepository.save(payStub);
        //logger.info(JsonUtil.jsonString(payStub1));

        payStubItemRepository.findAll().stream().map(JsonUtil::jsonString).forEach(logger::info);
    }

    @Test
    void savePayStubItem() {
        DeductionPayStubItem deductionPayStubItem = payStubItemRepository.save(new DeductionPayStubItem());
        logger.info(JsonUtil.jsonString(deductionPayStubItem));
    }
}