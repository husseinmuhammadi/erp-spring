package com.digiboy.erp.repository;

import com.digiboy.erp.to.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProductRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);

    @Autowired
    ProductRepository productRepository;

    @Test
    void save() {
        Product product = new Product();
        product.setName("A");
        productRepository.save(product);
        Product product1 = new Product();
        product1.setName("B");
        productRepository.save(product1);
        productRepository.findAll().forEach(p->logger.info("{} {}", p.getId(), p.getName()));
    }
}