package com.digiboy.erp.repository;

import com.digiboy.erp.to.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void save() {
        Product product = new Product();
        product.setName("A");

        productRepository.save(product);
    }

}