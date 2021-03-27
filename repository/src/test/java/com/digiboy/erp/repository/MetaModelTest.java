package com.digiboy.erp.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Metamodel;

@DataJpaTest
class MetaModelTest {

    private Logger logger = LoggerFactory.getLogger(MetaModelTest.class);

    @Autowired
    private EntityManager em;

    @Test
    void name() {
        Metamodel metamodel = em.getMetamodel();

        logger.info("{}", metamodel);
    }
}
