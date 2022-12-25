package com.investment.investment.product;

import com.investment.investment.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void existsByProductNameSuccess() {
        Boolean exists = productRepository.existsByProductName("Bank Bca");
        assertTrue(exists);
    }

    @Test
    void existsByProductNameNotSuccess(){
        Boolean exists = productRepository.existsByProductName("Bank apaan");
        assertFalse(exists);
    }
}