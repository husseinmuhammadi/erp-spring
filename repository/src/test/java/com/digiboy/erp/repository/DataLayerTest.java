package com.digiboy.erp.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class DataLayerTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void loadRequiredRepository(){
        Assertions.assertThat(productRepository).isNotNull();
    }
}
