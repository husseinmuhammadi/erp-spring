package com.digiboy.erp.repository;

import com.digiboy.erp.to.EntityStateHistory;
import com.digiboy.erp.to.Product;
import com.digiboy.erp.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EntityStateHistoryRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(EntityStateHistoryRepositoryTest.class);

    @Autowired
    private EntityStateHistoryRepository entityStateHistoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void name() {
        Product product = new Product();
        product.setName("p1");
        product.setState("E");
        productRepository.save(product);

        EntityStateHistory esh = new EntityStateHistory();
        esh.setEntity(product);
        esh.setState("E");
        entityStateHistoryRepository.save(esh);

        entityStateHistoryRepository.findAll().stream()
                .map(JsonUtil::jsonString)
                .forEach(logger::info);
    }
}